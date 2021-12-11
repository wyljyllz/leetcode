package leetcode.medium.math;

import java.util.Arrays;

/**
 * @ClassName DicesProbability
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class DicesProbability {
    /**
     * @description:动态规划
     * 分解子问题，通过子问题的解 f(n - 1)可递推计算出 f(n)
     * @author: 卫依伦
     * @date: 2021/11/29
     */
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];//只有一个骰子时,6种情况
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i+ 1];
            //每次的点数之和范围会有点变化，点数之和的值最大是i*6，最小是i*1，i之前的结果值是不会出现的；
            //比如i=3个骰子时，最小就是3了，不可能是2和1，所以点数之和的值的个数是6*i-(i-1)，化简：5*i+1
            for (int j = 0; j < dp.length; j++) { //往上递推
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] / 6.0; //累加
                }
            }
            dp = temp;
        }
        return dp;
    }
}
