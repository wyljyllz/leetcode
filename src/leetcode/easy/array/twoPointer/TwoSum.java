package leetcode.easy.array.twoPointer;

/**
 * @ClassName TwoSum
 * @Description 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s
 * @Author wyl
 * @Data
 */
public class TwoSum {
    /**
     * @description:双指针
     * @author: 卫依伦
     * @date: 2021/11/28
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];
    }

}
