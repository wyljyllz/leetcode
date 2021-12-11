package leetcode.easy.math;

/**
 * @ClassName PlusOne
 * @Description 加1
 * @Author wyl
 * @Data
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) { //不等于9
                ++digits[i];
                for (int j = i + 1; j < n; ++j) { //后面全补0
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

}
