package leetcode.easy.array.binary;

/**
 * @ClassName BinarySearch
 * @Description TODO查找数组中目标数字有多少个
 * @Author wyl
 * @Data
 */
public class BinarySearch {
    /**
     * @description:二分查找，找到目标值最左索引和最右索引
     * @author: 卫依伦
     * @date: 2021/11/27
     */
    public int search(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);//求左边界
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    /**
     * @description:优化
     * @author: 卫依伦
     * @date: 2021/11/27
     */
    public int search01(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
