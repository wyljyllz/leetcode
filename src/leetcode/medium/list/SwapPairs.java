package leetcode.medium.list;

import leetcode.dao.ListNode;

/**
 * @ClassName 两个节点两两交换
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class SwapPairs {
    /**
     * @description:使用递归
     * @author: 卫依伦
     * @date: 2021/11/2
     */
    public ListNode swapPairs (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;//交换后的头节点
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
    /**
     * @description:迭代
     * @author: 卫依伦
     * @date: 2021/11/2
     */
    public ListNode swapPairs01(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;//也就是之前的node2,现在的头结点
    }
}
