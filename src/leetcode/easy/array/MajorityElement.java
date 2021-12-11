package leetcode.easy.array;

/**
 * @ClassName MajorityElement
 * @Description 求占一半以上的数
 * @Author wyl
 * @Data
 */
public class MajorityElement {
    /**
     * @description:Boyer-Moore 投票算法
     * @author: 卫依伦
     * @date: 2021/11/24
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

}
