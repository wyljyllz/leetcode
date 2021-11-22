package leetcode.medium.dynamicProgramming;

/**
 * @ClassName CuttinfRope剪绳子/整数拆分，三段最大
 * 求最大乘积
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class CuttinfRope {
    public int cuttingRope(int n) {
        if(n<=3)return n-1;
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int len=4;len<=n;len++){
            for(int k=2;k<len-1;k++){
                dp[len]=Math.max(dp[len],dp[k]*dp[len-k]);
            }
        }
        return dp[n];
    }

    /**
     * @description:数学
     * @author: 卫依伦
     * @date: 2021/11/21
     */
    public int cuttingRope01(int n) {
        if(n == 2)return 1;
        if(n == 3)return 2;
        if(n == 4)return 4;
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res*n;
    }

}
