package leetcode.medium.string.window;

import java.util.Arrays;

/**
 * @ClassName CheckInclusion
 * @Description 字符串中的变位词
 * @Author wyl
 * @Data
 */
public class CheckInclusion {

    /**
     * @description:滑动窗口
     * @author: 卫依伦
     * @date: 2021/12/5
     */
    public boolean checkInclusion(String s1,String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {//窗口长度为n，s1字符串长度
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @description:滑动窗口，优化
     * @author: 卫依伦
     * @date: 2021/12/5
     */
    public boolean checkInclusion01(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                ++diff;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {//修改之前
                ++diff;
            }
            ++cnt[x];//修改
            if (cnt[x] == 0) {//修改后
                --diff;
            }
            if (cnt[y] == 0) {
                ++diff;
            }
            --cnt[y];
            if (cnt[y] == 0) {
                --diff;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * @description:双指针
     * [left,right] 的长度每增加 1，}cnt 的元素值之和就增加 1。
     * 当 [left,right] 的长度恰好为 n 时，就意味着cnt 的元素值之和为 0
     * @author: 卫依伦
     * @date: 2021/12/5
     */
    public boolean checkInclusion02(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) { //遍历s1
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) { //开始滑动
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) { //判断是否存在一个区间，其长度恰好为 n。
                return true;
            }
        }
        return false;
    }

}
