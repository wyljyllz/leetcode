package leetcode.easy;

/**
 * @ClassName 判断整数是否回文数
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class isPalindrome {
    public boolean isPalindrome (int x) {
        if (x  < 0 || x % 10 == 0 && x != 0) {//特殊情况
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) { //如果翻转的大于了x,代表翻转一半了
            revertedNumber = revertedNumber * 10 +  x % 10; //翻转的部分
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
    }
}
