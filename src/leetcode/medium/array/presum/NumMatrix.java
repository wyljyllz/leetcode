package leetcode.medium.array.presum;

/**
 * @ClassName NumMatrix
 * @Description  二维子矩阵的和
 * @Author wyl
 * @Data
 */
public class NumMatrix {
    /**
     * @description:一维前缀和，行
     * @author: 卫依伦
     * @date: 2021/12/5
     */
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i][j + 1] = sums[i][j] + matrix[i][j];//存储每行前缀和
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sums[i][col2 + 1] - sums[i][col1];
        }
        return sum;
    }

    /**
     * @description:二维前缀和
     * @author: 卫依伦
     * @date: 2021/12/5
     */
    class NumMatrix01 {
        int[][] sums;

        public NumMatrix01(int[][] matrix) {
            int m = matrix.length;
            if (m > 0) {
                int n = matrix[0].length;
                sums = new int[m + 1][n + 1];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                       //包括sums[i + 1][j + 1], 行不包括，列包括
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
        }
    }

}
