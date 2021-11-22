package leetcode.easy.array;

/**
 * @ClassName removeElement
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class removeElement {
    /**
     * @description:双指针暴力
     * @author: 卫依伦
     * @date: 2021/11/6
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
    /**
     * @description:双指针优化
     * @author: 卫依伦
     * @date: 2021/11/6
     */
    public int removeElement01(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

}
