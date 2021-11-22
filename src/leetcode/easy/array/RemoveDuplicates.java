package leetcode.easy.array;

/**
 * @ClassName RemoveDuplicates去除有序数组中重复元素
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class RemoveDuplicates {
    public int removeDuplicates (int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {//判断，将重复元素的值赋值给慢指针
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
