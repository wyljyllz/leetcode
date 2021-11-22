package leetcode.medium.math;

/**
 * @ClassName IsValidSudoku
 * 判断是否是有效的数独
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class IsValidSudoku {
    /**
     * @description:通过三个数组来存储每一行每一列每一块中出现的元素，利用角标及对应的值。
     * @author: 卫依伦
     * @date: 2021/11/18
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];//拿到元素
                if (c != '.') {
                    int index = c - '0' - 1;//通过ascll码计算值
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3] [index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
