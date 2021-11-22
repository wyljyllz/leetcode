package leetcode.medium.dynamicProgramming;

/**
 * @ClassName Rob打家劫舍
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class Rob {
    /**
     * @description:
     * @author: 卫依伦
     * @date: 2021/11/12
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    /**
     * @description:改进，不使用数组,迭代
     * @author: 卫依伦
     * @date: 2021/11/12
     */
    public static int rob01(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length, temp;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    }
}
