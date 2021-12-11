package leetcode.easy.array;

import java.util.Arrays;

/**
 * @ClassName PivotOIndex
 * @Description 寻找数组的中心下标
 * @Author wyl
 * @Data
 */
public class PivotOIndex {

    /**
     * @description:前缀和
     * 左侧和为sum,total - sum - nums[i] = sum,2 * sum + nums[i] == total为判断条件
     * @author: 卫依伦
     * @date: 2021/12/5
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
