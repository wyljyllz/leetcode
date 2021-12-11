package leetcode.easy.array.presum;

/**
 * @ClassName NumArray
 * @Description 区域和检索 - 数组不可变
 * @Author wyl
 * @Data
 */
public class NumArray {

    /**
     * @description:前缀和
     * @author: 卫依伦
     * @date: 2021/12/5
     */
    int[] sums;

    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];// n - 1个
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

}
