package leetcode.easy.dynamicProgramming;

/**
 * @ClassName climbStairs动态规划
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class climbStairs {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;//f(x−2)
            q = r;//f(x−1)
            r = p + q;//f(x)=f(x−1)+f(x−2)
        }
        return r;
    }
}
