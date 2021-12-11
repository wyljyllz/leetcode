package leetcode.easy.stack;

import java.util.Stack;

/**
 * @ClassName MinStack
 * @Description TODO实现最小栈
 * @Author wyl
 * @Data
 */
public class MinStack {
    /**
     * @description:利用辅助栈
     * @author: 卫依伦
     * @date: 2021/11/22
     */
    Stack<Integer> A, B;
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x) //空或者小于之前最小，入栈
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();//peek返回元素，不删除
    }
    public int min() {
        return B.peek();
    }
    /**
     * @description:辅助数组，栈内存数组
     * @author: 卫依伦
     * @date: 2021/11/23
     */
    class MinStack01 {

        // 数组栈, [当前值, 当前最小值]
        private Stack<int[]> stack = new Stack<>();

        public MinStack01() {

        }

        public void push(int x) {
            if (stack.isEmpty()){
                stack.push(new int[]{x, x});
            }else {
                stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }

    static class MinStack02 {
        Stack<Integer> stack = new Stack<>();
        Integer min = null;
        public void push(int node) {
            if(min == null){
                min = node;
                stack.push(0);
            }
            else{
                stack.push(node - min);
                if(node < min)
                    min = node;
            }
        }

        public void pop() {
            int node = stack.pop();
            if(node < 0)
                min = min - node;
        }

        public int top() {
            int node = stack.peek();
            if(node < 0)
                return min;
            else
                return node + min;
        }

        public int min() {
            return min;
        }
    }

    public static void main(String[] args) {
//        MinStack02 minStack02 = new MinStack02();
//        minStack02.push(-1);
//        minStack02.push(2);
//        minStack02.push(-3);
//        int min = minStack02.min();
//        System.out.println(min);
//        minStack02.pop();
//        int top = minStack02.top();
//        System.out.println(top);

    }
}
