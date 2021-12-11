package leetcode.easy.math;

/**
 * @ClassName LastRemaining
 * @Description 圆圈中最后剩下的数字
 * @Author wyl
 * @Data
 */
public class LastRemaining {
    /**
     * @description:递归，分解子问题
     删除了第 m % n 个元素，将序列的长度变为 n - 1。当我们知道了 f(n - 1, m) 对应的答案 x 之后，
     可以知道，长度为 n 的序列最后一个删除的元素，应当是从 m % n 开始数的第 x 个元素。
     因此有 f(n, m) = (m % n + x) % n = (m + x) % n。
     * @author: 卫依伦
     * @date: 2021/11/28
     */
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    /**
     * @description:迭代
     * @author: 卫依伦
     * @date: 2021/11/28
     */
    public int lastRemaining01(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }
}
