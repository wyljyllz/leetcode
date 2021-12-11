package leetcode.medium.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName 找出其中不含有重复字符的最长子串的长度。
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class LenfthOfSubString {
    /**
     * @description:暴力枚举
     * @author: 卫依伦
     * @date: 2021/11/23
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int num = 1,max = 0;
        Boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            for (int k = i + 1; k < chars.length && flag; k++) {
                for (int m = k - 1 ; m >= i; m--) {
                    if (chars[m] != chars[k])
                        num++; //不相等，就加1
                    else {
                        flag = false; //跳出chars[i]开始的
                        break; //结束比较
                    }
                }
                max = Math.max(max,num);
                num = 1;
            }
            flag = true;
            if (max == 0) {
                max = 1;
            }
        }
        return max;
    }
    /**
     * @description:滑动窗口
     * 只需遍历一遍
     * @author: 卫依伦
     * @date: 2021/11/23
     */
    public int lengthOfLongestSubstring01(String s) {
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));//左指针向右移动一格，移除一个字符
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);//保证（i，rk)内为连续不重复字符串
        }
        return ans;
    }
    public static void main(String[] args) {
//        int i = lengthOfLongestSubstring(" ");
//        System.out.println(i);
    }
}
