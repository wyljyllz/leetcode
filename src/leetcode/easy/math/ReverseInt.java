package leetcode.easy.math;

/**
 * @ClassName 翻转一个整数
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class ReverseInt {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;//在求rev *10 + dight 之前判断是否会溢出
            }
            int dight = x % 10;
            x /= 10;
            rev = rev * 10 + dight;//
        }
        return rev;
    }
}
