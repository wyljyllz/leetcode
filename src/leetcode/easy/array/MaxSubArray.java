package leetcode.easy.array;

/**
 * @ClassName MaxSubArray
 * 求最大子序和
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);//舍弃，迭代
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
