package leetcode.medium.list;

import leetcode.dao.ListNode;

/**
 * @ClassName RemoveNthFromEnd
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class RemoveNthFromEnd {
    /**
     * @description:删除倒数第n个节点，使用快慢指针，注意head元素也可能被删除
     * @author: 卫依伦
     * @date: 2021/11/2
     */
    public static ListNode remvoNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode pre = head;
        ListNode second = head;
        for (int i = 0; i < n ; i++) {
            first = first.next;
        }
        while (first != null) {
            pre = second;
            first = first.next;
            second = second.next;
        }
        if (second == head) //删除head节点的情况
            return head.next;
        pre.next = second.next;
        return head;
    }
    /**
     * @description:使用哑节点，快慢指针
     * @author: 卫依伦
     * @date: 2021/11/2
     */
    public ListNode removeNthFormEnd01(ListNode head, int n) {
        ListNode dumy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dumy.next;//解决head节点被删除的情况
        return ans;
    }

}
