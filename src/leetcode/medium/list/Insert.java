package leetcode.medium.list;

/**
 * @ClassName Insert
 * @Description 排序的循环链表
 * @Author wyl
 * @Data
 */
public class Insert {
    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node node=new Node(insertVal);
            node.next=node;
            return node;
        }
        Node max=head,min=head;
        Node p=head.next;
        while (p!=head){
            if(p.val>max.val)max=p;
            if(p.val<min.val)min=p;
            p=p.next;
        }
        if(max==min){
            max.next=new Node(insertVal,max.next);
        }
        else if(insertVal>=max.val||insertVal<=min.val){
            while (max.next.val==max.val)max=max.next;//找到最后一个
            max.next=new Node(insertVal,max.next);//插入过程
        }else{
            while (min.next.val<insertVal)min=min.next;
            min.next=new Node(insertVal,min.next);
        }
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

}
