package leetcode.easy.string;

/**
 * @ClassName 字符串匹配
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class StrStr {
    /**
     * @description:暴力匹配
     * @author: 卫依伦
     * @date: 2021/11/7
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length(),m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
    /**
     * @description:暴力匹配
     * @author: 卫依伦
     * @date: 2021/11/7
     */
    public static int strStr01(String ts, String ps) {
        int i = 0;
        int j = 0;
        while (i < ts.length() && j < ps.length()) {
            if (ts.charAt(i) == ps.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == ps.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * @description:KMP
     * @author: 卫依伦
     * @date: 2021/11/7
     */
    public int strStr03(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0)
            return 0;
        int [] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {  //求前缀数组
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1]; //循环过程
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                if (j == m)
                    return i - m + 1;
            }
        return -1;
        }

        /**
         * @description:kmp
         * @author: 卫依伦
         * @date: 2021/11/7
         */
        public int Kmp(String ts, String ps) {
            int n = ts.length(), m = ps.length();
            if (m == 0)
                return 0;
            int [] pi = new int[m];
            pi[0] = -1;
            for (int j = 0, k = -1; j < m - 1;) {
                if (k == -1 || ps.charAt(j) == ps.charAt(k)) {
                    pi[++j] = ++k;
                } else {
                    k = pi[k];
                }
            }
            for (int i = 0, j = 0; i < n;) {
                if (j == -1 || ts.charAt(i) == ps.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = pi[j];
                }
                if (j == m)
                    return i - m;
            }
            return -1;
        }
}
