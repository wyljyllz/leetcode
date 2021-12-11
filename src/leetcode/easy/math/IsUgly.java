package leetcode.easy.math;

/**
 * @ClassName IsUgly
 * @Description 是否是丑数
 * @Author wyl
 * @Data
 */
public class IsUgly {
    /**
     * @description:对 n反复除以 2,3,5
     * @author: 卫依伦
     * @date: 2021/11/27
     */
    public boolean isUgly(int n) {
        if (n <= 0)
            return false;
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
