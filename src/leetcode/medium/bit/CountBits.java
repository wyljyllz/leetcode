package leetcode.medium.bit;

/**
 * @ClassName CountBits
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class CountBits {

    /**
     * @description:Brian Kernighan 算法
     * x=x & (x−1)，该运算将 x 的二进制表示的最后一个 1 变成 0
     * @author: 卫依伦
     * @date: 2021/12/4
     */
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

    /**
     * @description:动态规划-最高有效位
     * @author: 卫依伦
     * @date: 2021/12/4
     */
    public int[] countBits01(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) { //正整数 y 是 2 的整数次幂，当且仅当 y & (y−1)=0。
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }
    /**
     * @description:动态规划，最低位有效
     * @author: 卫依伦
     * @date: 2021/12/4
     */
    public int[] countBits02(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

}
