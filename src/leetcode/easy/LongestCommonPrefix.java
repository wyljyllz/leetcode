package leetcode.easy;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * @ClassName LongestCommonPrefix
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class LongestCommonPrefix {
    /**
     * @description:穷举法
     * @author: 卫依伦
     * @date: 2021/11/1
     */
    public static String longestCommonPrefix(String[] strs) {
        int minFir = strs[0].length();
        for (int m = 0; m < strs.length; m++) {
            minFir = Math.min(strs[m].length(),minFir);
        }
        boolean flag = true;
        String maxPrefix = "";
        for (int i = 0; i < minFir; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[j - 1].charAt(i)) {//比较
                    flag = false;//设置
                    break;
                }
            }
            if (flag) {//判断
                maxPrefix = maxPrefix + strs[0].charAt(i);//添加
                flag = true;
            } else
                break;

        }
        return maxPrefix;
    }

    /**
     * @description:拆分，横向比较
     * @author: 卫依伦
     * @date: 2021/11/1
     */
    public static String longestCommonPrefix01(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longerstCommonPrefix(prefix, strs[i]);//找出两个的公共前缀，不断迭代
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    /**
     * @description:找出两个字符串的最长公共前缀
     * @author: 卫依伦
     * @date: 2021/11/1
     */
    private static String longerstCommonPrefix(String str1, String str2) {
    int length = Math.min(str1.length(), str2.length());
    int index = 0;
    while (index < length && str1.charAt(index) == str2.charAt(index)) {
        index++;
    }
    return str1.substring(0, index);//截取出最长公共前缀
    }

    /**
     * @description:纵向扫描
     * @author: 卫依伦
     * @date: 2021/11/1
     */
    public String longestCommonPrefix03(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) { //终止条件
                    return strs[0].substring(0, i);//截取
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs =  new String[]{"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s.toString());
    }
}
