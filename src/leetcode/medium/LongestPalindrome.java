package leetcode.medium;

/**
 * @ClassName 求最长的回文子串
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class LongestPalindrome {
    /**
     * @description:动态规划
     * @author: 卫依伦
     * @date: 2021/10/30
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int L = 2; L <= len; L++) { //子串从2开始，最长len,从小到大
            for (int i = 0; i < len; i++) {
                int j = L + i - 1;//计算j
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if ( j - i < 3) { //两个字母，返回true
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];//状态转移方程，此时dp为true
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * @description:中心拓展算法
     * @author: 卫依伦
     * @date: 2021/10/30
     */
    public static String longestPalindrome01(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);//边界为1，abcba
            int len2 = expandAroundCenter(s,i, i + 1);//边界为2，abccba;
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return  s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {//left等于right
            --left;
            ++right;
        }
        return right - left - 1;

    }
}
