package leetcode.medium.array;

import java.util.Arrays;

/**
 * @ClassName MinSuubArrayLen
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class MinSuubArrayLen {
    /**
     * @description:,前缀和+二分查找
     * @author: 卫依伦
     * @date: 2021/12/5
     */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) { //查找的value包含在数组中，则返回搜索value的索引；否则返回 (-(插入点) - 1)
                bound = - bound - 1;//因为递增，插入点一定符合
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    /**
     * @description:滑动窗口
     * @author: 卫依伦
     * @date: 2021/12/5
     */
    public int minSubArrayLen01(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
