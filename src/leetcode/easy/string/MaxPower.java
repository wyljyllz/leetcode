package leetcode.easy.string;

/**
 * @ClassName MaxPower
 * @Description 连续字符
 * @Author wyl
 * @Data
 */
public class MaxPower {
    /**
     * @description:双指针遍历
     * @author: 卫依伦
     * @date: 2021/12/1
     */
    public int maxPower(String s) {
        int n = s.length(), ans = 1;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;
    }

    /**
     * @description:一次遍历
     * @author: 卫依伦
     * @date: 2021/12/1
     */
    public int maxPower01(String s) {
        int ans = 1, cnt = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++cnt;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }

}
