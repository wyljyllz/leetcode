package leetcode.medium.other;

import java.util.Stack;

/**
 * @ClassName 找出碰撞后剩下的所有行星
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class asteroidCollision {
        public static int[] asteroidCollion(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();
            for(int ast : asteroids) {
                collsion: {
                while (!stack.isEmpty() && ast < 0 && stack.peek() >0) {
                    if(stack.peek() < -ast) {
                        stack.pop();
                        continue ;//继续
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collsion;//跳出代码块
                }
                stack.push(ast);
                }
            }

            int[] ans = new int[stack.size()];
            for (int t = ans.length - 1; t >= 0; --t) { //输出遍历
                ans[t] = stack.pop();
            }
            return ans;
        }

}
