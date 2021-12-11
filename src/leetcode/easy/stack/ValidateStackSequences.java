package leetcode.easy.stack;

import java.util.Stack;

/**
 * @ClassName ValidateStackSequences
 * @Description TODO验证栈序列
 * @Author wyl
 * @Data
 */
public class ValidateStackSequences {

    /**
     * @description:模拟栈过程进行判断
     * 要求栈内元素不能重复
     * @author: 卫依伦
     * @date: 2021/11/23
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();
        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == N;
    }

}
