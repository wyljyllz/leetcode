package leetcode.easy.math;

/**
 * @ClassName HanmingWeigh求二进制中1的个数
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class HanmingWeight {

    /**
     * @description:位运算之与
     * @author: 卫依伦
     * @date: 2021/11/21
     */
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    /**
     * @description:位运算优化
     * @author: 卫依伦
     * @date: 2021/11/21
     */
    public int hammingWeight01(int n) {
        int ret = 0;
        while (n != 0) { //n & (n−1)，其预算结果恰为把 nn 的二进制位中的最低位的 11 变为 00 之后的结果。
            n &= n - 1;
            ret++;
        }
        return ret;
    }

}
