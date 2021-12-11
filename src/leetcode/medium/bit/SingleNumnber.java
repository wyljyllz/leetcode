package leetcode.medium.bit;

/**
 * @ClassName SingleNumnber
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class SingleNumnber {
    /**
     * @description:统计所有数字的各二进制位中 1 的出现次数，并对 3 求余，结果则为只出现一次的数字。
     * @author: 卫依伦
     * @date: 2021/11/29
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;//计算完One，已经到下一状态
        }
        return ones;//最终会回到只出现1次的那个数字
    }

    /**
     * @description:遍历统计
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    public int singleNumber01(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1); //求和除余
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
