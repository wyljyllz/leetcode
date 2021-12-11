package leetcode.easy.math;

/**
 * @ClassName Add
 * @Description 两个整数相加
 * @Author wyl
 * @Data
 */
public class Add {
    /**
     * @description:迭代
     * @author: 卫依伦
     * @date: 2021/11/27
     */
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出，有几次进位循环几次
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    /**
     * @description:递归
     * @author: 卫依伦
     * @date: 2021/11/27
     */
    public int add01(int a, int b) {
        if (b == 0) {
            return a;
        }

        // 转换成非进位和 + 进位
        return add01(a ^ b, (a & b) << 1);
    }
}
