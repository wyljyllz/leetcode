package leetcode.medium.array;

/**
 * @ClassName Jump使用最少的跳跃次数到达数组的最后一个位置。
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class Jump {
    /**
     * @description:求跳跃次数，贪心，从前到后
     * @author: 卫依伦
     * @date: 2021/11/8
     */
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一,跳之前步数就加1
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
    /**
     * @description:求跳跃次数，动态规划
     * @author: 卫依伦
     * @date: 2021/11/8
     */
    public int jump01(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = nums.length + 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);//前一个dp加一步
                }

            }
        }
        return dp[dp.length - 1];
    }
    /**
     * @description:求跳跃次数贪心，从后到前
     * @author: 卫依伦
     * @date: 2021/11/8
     */
    public int jump02(int[] nums) {
        int position = nums.length - 1; //要找的位置
        int steps = 0;
        while (position != 0) { //是否到了第 0 个位置
            for (int i = 0; i < position; i++) { //
                if (nums[i] >= position - i) {
                    position = i; //更新要找的位置
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    /**
     * @description:判断能否跳到最后一个，贪心
     * @author: 卫依伦
     * @date: 2021/12/2
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
