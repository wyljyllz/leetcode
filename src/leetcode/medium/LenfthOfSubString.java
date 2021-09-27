package leetcode.medium;

import java.util.Arrays;

/**
 * @ClassName 找出其中不含有重复字符的 最长子串 的长度。
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class LenfthOfSubString {
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

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring(" ");
        System.out.println(i);
    }
}
