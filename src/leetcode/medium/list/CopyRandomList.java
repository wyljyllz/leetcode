package leetcode.medium.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CopyRandomList
 * @Description 复杂链表的复制
 * @Author wyl
 * @Data
 */
public class CopyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    /**
     * @description:回溯+哈希表
     * 遍历该链表的过程中，我们检查「当前节点的后继节点」和「当前节点的随机指针指向的节点」的创建情况。
     * 如果这两个节点中的任何一个节点的新节点没有被创建，立刻递归地进行创建。
     * @author: 卫依伦
     * @date: 2021/11/24
     */
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);//返回headNew
    }

    /**
     * @description:哈希，迭代
     * @author: 卫依伦
     * @date: 2021/11/24
     */
    public Node copyRandomList02(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        HashMap<Node,Node> map = new HashMap<>();
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur=head;
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
    /**
     * @description:迭代+节点拆分
     * @author: 卫依伦
     * @date: 2021/11/24
     */
    public Node copyRandomList01(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) { //先建立next关系
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {//再建立random关系
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) { //复位,拆分
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}
