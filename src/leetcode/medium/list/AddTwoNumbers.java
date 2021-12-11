package leetcode.medium.list;

import leetcode.dao.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName AddTwoNumbers
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class AddTwoNumbers {
    /**
     * @description:栈
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;//建立一个空结点
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;//指向前一个
            ans = curnode;
        }
        return ans;
    }
    /**
     * @description:递归，进行标记
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public ListNode addTwoNumbers01(ListNode l1, ListNode l2) {
        int len1 = 0,len2 = 0;
        ListNode p1 = l1,p2 = l2;
        //长度计算
        while(p1 != null){ len1 ++; p1 = p1.next; }
        while(p2 != null){ len2 ++; p2 = p2.next; }
        //保证p1长度最长
        if(len1 < len2){ p1 = l2; p2 = l1; }
        else { p1 = l1; p2 = l2; }
        //根据长度差值在p1处对应处标记
        int diff = Math.abs(len1 - len2);
        ListNode p = p1;
        while(diff-- > 0) p = p.next;
        p.val += 10;//标记
        //P1补1位，进入递归，递归返回进位计算
        ListNode newp1 = new ListNode(0,p1);
        addTwoListNode(newp1,p2,false);
        //若最高位无进位，返回next
        return newp1.val == 0 ? newp1.next : newp1;
    }
    int addTwoListNode(ListNode p1,ListNode p2,boolean flag){
        if(p1 == null) return 0;
        if(p1.val >= 10) {p1.val -= 10; flag = true; }
        int addp2 = flag ? p2.val : 0;
        if(flag) p2 = p2.next;
        p1.val += addTwoListNode(p1.next,p2,flag) + addp2;
        int d = p1.val / 10;
        p1.val %= 10;
        return d;
    }
}
