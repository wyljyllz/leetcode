package leetcode.medium.array;

import java.util.Arrays;

/**
 * @ClassName SerpentineArray
 * @Description TODO蛇形数组，对角线打印
 * @Author wyl
 * @Data
 */
public class SerpentineArray {

    /**
     * @description:找规律。
     * @author: 卫依伦
     * @date: 2021/11/25
     */
    public static int[][] SerpentineArray(int n) {
        int[][] nums = new int[n][n];
        int flag = 0, row = 0, cloumn = 0, sum = 1;
        for (int k = 0; k < n; k++) { //上半部分
            if (flag == 0) {
                row = k;
                cloumn = 0;
               while (cloumn <= k) {
                    nums[row--][cloumn++] = sum++;
               }
               flag = 1;
            } else {
                row = 0;
                cloumn = k;
                while (cloumn >= 0) {
                    nums[row++][cloumn--] = sum++;
                }
                flag = 0;
            }
        }
        for (int k = 1; k < n; k++) { //下半部分
            if (flag == 0) {
                row = n - 1;
                cloumn = k;
                while (cloumn < n) {
                    nums[row--][cloumn++] = sum++;
                }
                flag = 1;
            } else {
                row = k;
                cloumn = n - 1;
                while (cloumn >=  k) {
                    nums[row++][cloumn--] = sum++;
                }
                flag = 0;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] ints = SerpentineArray(9);
       for (int i = 0; i < ints.length; i++) {
           for (int j = 0; j < ints[0].length; j++) {
               if (ints[i][j] >= 10) {
                   System.out.print(ints[i][j] + "  ");
               } else {
                   System.out.print(ints[i][j] + "   ");
               }

           }
           System.out.println("");
       }
    }
}
