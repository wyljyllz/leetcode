package leetcode.easy.array.twoPointer;

/**
 * @ClassName Exchange
 * 调整数组顺序使奇数位于偶数前面
 * 双指针
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++;
            while (i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
