package leetcode.easy.math;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName IsValid判断括号是否有效
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class IsValid {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character,Character> pairs = new HashMap<Character,Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) { //如果是右括号
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);//左括号入栈
            }
        }
        return stack.isEmpty();
    }
}
