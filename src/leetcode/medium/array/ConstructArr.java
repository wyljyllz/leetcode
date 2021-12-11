package leetcode.medium.array;

/**
 * @ClassName ConstructArr
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class ConstructArr {
    /**
     * @description:将表格分为 上三角 和 下三角 两部分。分别迭代计算下三角和上三角两部分的乘积
     * @author: 卫依伦
     * @date: 2021/11/29
     */
    public int[] constructArr(int[] a) {
        int len = a.length;
        if(len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < len; i++) {//计算左下
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = len - 2; i >= 0; i--) {//计算右上
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
