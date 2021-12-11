package leetcode.easy.array.binary;

/**
 * @ClassName SearchIncert
 * 二分查找目标元素在数组中的位置
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class SearchIncert {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1,ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    public int searchInsert01(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if(nums[mid] < target)
            {
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return left;
    }


}
