package leetcode.easy.array;

import java.util.Arrays;

/**
 * @ClassName FindRelativeRanks
 * @Description 相对名次
 * @Author wyl
 * @Data
 */
public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) { //{{成绩，索引}，{成绩，索引}}
            arr[i][0] = score[i];//保存成绩
            arr[i][1] = i;//保存索引
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            if (i >= 3) {
                ans[arr[i][1]] = Integer.toString(i + 1);
            } else {
                ans[arr[i][1]] = desc[i];
            }
        }
        return ans;
    }
}
