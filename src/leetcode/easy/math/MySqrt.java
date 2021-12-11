package leetcode.easy.math;

/**
 * @ClassName MySqrt
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class MySqrt {

    /**
     * @description:二分查找
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    /**
     * @description:牛顿迭代
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    public int mySqrt01(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
