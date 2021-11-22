package leetcode.medium.list;

import leetcode.dao.ListNode;

/**
 * @ClassName MergeTwoLists合并两个有序链表
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class MergeTwoLists {
    /**
     * @description:使用递归
     * @author: 卫依伦
     * @date: 2021/11/2
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)  { //终止条件
            return l2;
        } else if (l2 == null){
            return l1;
        } else {
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
    /**
     * @description:使用迭代
     * @author: 卫依伦
     * @date: 2021/11/2
     */
    public ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);//新建一个结点
        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;//进行判断
        return preHead.next;
    }
}
