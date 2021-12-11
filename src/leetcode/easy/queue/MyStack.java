package leetcode.easy.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MyStack
 * @Description 用队列实现栈
 * @Author wyl
 * @Data
 */
public class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int cnt = queue.size();
        while (cnt-- > 1) {//留一个，其他全部转
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
