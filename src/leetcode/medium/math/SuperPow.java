package leetcode.medium.math;

/**
 * @ClassName SuperPow
 * @Description 超级次方
 * @Author wyl
 * @Data
 */
public class SuperPow {
    /**
     * @description:倒序遍历
     * @author: 卫依伦
     * @date: 2021/12/5
     */
    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i]) % MOD);//取模
            a = pow(a, 10);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);//// 如果 N 二进制表示的最低位为 1，那么需要计入贡献
            }
            x = (int) ((long) x * x % MOD);//// 将贡献不断地平方
            n /= 2;
        }
        return res;
    }

    /**
     * @description:秦九韶算法
     * @author: 卫依伦
     * @date: 2021/12/5
     */
    public int superPow01(int a, int[] b) {
        int ans = 1;
        for (int e : b) {
            ans = (int) ((long) pow(ans, 10) * pow(a, e) % MOD);
        }
        return ans;
    }


}
