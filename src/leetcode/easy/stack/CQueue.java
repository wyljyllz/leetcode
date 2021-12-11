package leetcode.easy.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName CQueue
 * 使用两个栈来实现队列
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public CQueue() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }
    class MyQueue {

        private Stack<Integer> in = new Stack<>();
        private Stack<Integer> out = new Stack<>();

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            in2out();
            return out.pop();//本身的pop
        }

        public int peek() {
            in2out();
            return out.peek();//返回不弹出
        }

        private void in2out() { //把第一个栈的元素转到第二个栈
            if (out.isEmpty()) {//空才转，不然直接弹出
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
