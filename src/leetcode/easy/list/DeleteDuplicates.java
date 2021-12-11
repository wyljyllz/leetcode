package leetcode.easy.list;

import leetcode.dao.ListNode;

/**
 * @ClassName DeleteDuplicates
 * @Description 删除链表重复元素
 * @Author wyl
 * @Data
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
