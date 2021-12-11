package leetcode.medium.dynamicProgramming;

/**
 * @ClassName TranslateNumber
 * @Description 将数字翻译成字符串
 * @Author wyl
 * @Data
 */
public class TranslateNumber {
    /**
     * @description:动态规划 滚动数组
     * @author: 卫依伦
     * @date: 2021/11/26
     */
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }

    /**
     * @description:动态规划计算是 对称的 ，即 从左向右 遍历（从第 dp[2]dp[2] 计算至 dp[n]dp[n] ）和
     * 从右向左 遍历（从第 dp[n - 2]dp[n−2] 计算至 dp[0]dp[0] ）所得方案数一致，可以通过求余降低空间复杂度
     * @author: 卫依伦
     * @date: 2021/11/26
     */
    public int translateNum02(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}
