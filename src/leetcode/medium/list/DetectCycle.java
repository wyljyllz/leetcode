package leetcode.medium.list;

import leetcode.dao.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName DetectCycle
 * @Description
 * @Author wyl
 * @Data
 */
public class DetectCycle {

    /**
     * @description:哈希表
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    /**
     * @description:快慢指针
     *  f = 2s，f=s+nb，s = nb，k = a + nb（先走 a 步到入口节点，之后每绕 1 圈环（ b 步）都会再次到入口节点）。
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public ListNode detectCycle01(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public ListNode detectCycle02(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


}
