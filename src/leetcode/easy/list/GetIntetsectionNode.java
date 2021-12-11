package leetcode.easy.list;

import leetcode.dao.ListNode;

/**
 * @ClassName GetIntetsectionNode
 * @Description TODO判断两个链表是否相交
 * @Author wyl
 * @Data
 */
public class GetIntetsectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
