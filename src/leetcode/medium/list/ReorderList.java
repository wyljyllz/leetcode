package leetcode.medium.list;

import leetcode.dao.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ReorderList
 * @Description 重排链表
 * @Author wyl
 * @Data
 */
public class ReorderList {
    /**
     * @description:线性表
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
    /**
     * @description:寻找链表中点 + 链表逆序 + 合并链表
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public void reorderList01(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;//中间结点的next结点
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;
            l1.next = l2;
            l1 = l1_tmp;//更新
            l2.next = l1;
            l2 = l2_tmp;//更新
        }
    }
    /**
     * @description:递归
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public void reorderList0(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)return;
        ListNode temp = head;
        while(temp.next.next != null)
            temp = temp.next;//找到倒数第二个
        temp.next.next = head.next;
        head.next = temp.next;
        temp.next = null;//断开指向
        reorderList0(head.next.next);
    }
}

