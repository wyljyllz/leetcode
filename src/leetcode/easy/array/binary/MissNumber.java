package leetcode.easy.array.binary;

/**
 * @ClassName MissNumber
 * @Description 0～n-1中缺失的数字
 * @Author wyl
 * @Data
 */
public class MissNumber {
    /**
     * @description:二分查找
     * @author: 卫依伦
     * @date: 2021/11/27
     */
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

}
