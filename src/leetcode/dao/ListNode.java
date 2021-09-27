package leetcode.dao;

/**
 * @ClassName ListNode
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class ListNode {
    public ListNode next;
    public int val;
    ListNode() {}
    public ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
