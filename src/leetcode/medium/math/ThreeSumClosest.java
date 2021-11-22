package leetcode.medium.math;

import java.util.Arrays;

/**
 * @ClassName 最接近的三数之和,通过排序，双指针
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class ThreeSumClosest {
    public int threeSumCloest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 1000000;
        //枚举
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;//双指针
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return target;
                if (Math.abs(sum - target) < Math.abs(best - target)) { //通过引入中间量，比较绝对值，进行更新
                    best = sum;
                }
                if (sum > target) {
                    int k0 = k - 1;
                    while (j < k0 && nums[k0] == nums[k]) {
                        k0--;
                    }
                    k = k0;
                } else {
                    int j0 = j + 1;
                    while (j0 < k && nums[j0] == nums[j]) {
                        j0++;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }
}
