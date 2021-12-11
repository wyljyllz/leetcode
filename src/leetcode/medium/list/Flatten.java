package leetcode.medium.list;

/**
 * @ClassName Flatten
 * @Description 展平多级双向链表
 * @Author wyl
 * @Data
 */
public class Flatten {

    /**
     * @description:深度优先搜索
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node node) {
        Node cur = node;
        // 记录链表的最后一个节点
        Node last = null;

        while (cur != null) {
            Node next = cur.next;
            //  如果有子节点，那么首先处理子节点
            if (cur.child != null) {
                Node childLast = dfs(cur.child);

                next = cur.next;
                //  将 node 与 child 相连
                cur.next = cur.child;
                cur.child.prev = cur;

                //  如果 next 不为空，就将 last 与 next 相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                // 将 child 置为空
                cur.child = null;
                last = childLast;//如果next为null，此时last为上一个的last
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

}
