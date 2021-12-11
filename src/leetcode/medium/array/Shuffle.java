package leetcode.medium.array;

import java.util.Random;

/**
 * @ClassName Shuffle
 * @Description 随机打乱数组
 * @Author wyl
 * @Data
 */
public class Shuffle {
    int[] nums;
    int[] original;

    public Shuffle(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length); //数组的复制
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length);
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = i + random.nextInt(nums.length - i); //随机生成【i,n);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
