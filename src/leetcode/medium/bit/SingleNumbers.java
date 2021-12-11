package leetcode.medium.bit;

/**
 * @ClassName SingleNumbers
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class SingleNumbers {
    /**
     * @description:位运算
     * 先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
     * 在异或结果中找到任意为 1 的位。
     * 根据这一位对所有的数字进行分组。
     * 在每个组内进行异或操作，得到两个数字。
     * @author: 卫依伦
     * @date: 2021/11/29
     */
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) { //得到两个出现一次的数字的异或值。
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) { //肯定有一位不同，得到最左的1，通过div进行区分，分组
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
