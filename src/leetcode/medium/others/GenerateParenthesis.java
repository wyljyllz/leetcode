package leetcode.medium.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GenerateParenthesis
 * 生成括号
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class GenerateParenthesis {

    /**
     * @description:暴力+验证
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> combinations = new ArrayList<String>();
            generateAll(new char[2 * n], 0, combinations);
            return combinations;
        }

        public void generateAll(char[] current, int pos, List<String> result) {
            if (pos == current.length) {
                if (valid(current)) {
                    result.add(new String(current));
                }
            } else {
                current[pos] = '(';
                generateAll(current, pos + 1, result);
                current[pos] = ')';
                generateAll(current, pos + 1, result);
            }
        }

        public boolean valid(char[] current) { //验证
            int balance = 0;
            for (char c: current) {
                if (c == '(') {
                    ++balance;
                } else {
                    --balance;
                }
                if (balance < 0) {
                    return false;
                }
            }
            return balance == 0;
        }
    }

    /**
     * @description:递归，左右括号从 n 开始递减，反向
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    List<String> ans = new ArrayList<String>();
    public void recursion(int left, int right, int level, String str) {

        if(level == 0) {
            //System.out.println(str);
            ans.add(str);
            return ;
        }
        if(left > 0)
            recursion(left -1, right, level - 1,  str + "(");
        if(right > left)
            recursion(left, right - 1, level - 1, str + ")");
    }

    public List<String> generateParenthesis01(int n) {

        recursion(n, n, 2 * n, "");

        return ans;
    }

    /**
     * @description:回溯，正向
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
