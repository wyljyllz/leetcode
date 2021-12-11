package leetcode.medium.dynamicProgramming;

/**
 * @ClassName MaxValue
 * @Description TODO礼物的最大价值
 * @Author wyl
 * @Data
 */
public class MaxValue {
    /**
     * @description:动态规划
     * @author: 卫依伦
     * @date: 2021/11/27
     */
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值，这样不用考虑边界
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }
    /**
     * @description:动态规划，减少空间，操作原本数组
     * @author: 卫依伦
     * @date: 2021/11/27
     */
    public int maxValue01(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1],grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
