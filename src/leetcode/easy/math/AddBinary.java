package leetcode.easy.math;

/**
 * @ClassName AddBinary
 * @Description 二进制求和
 * @Author wyl
 * @Data
 */
public class AddBinary {
    /**
     * @description:
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    /**
     * @description:模拟
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    public String addBinary01(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) { //最后的判断
            ans.append('1');
        }
        ans.reverse();//翻转

        return ans.toString();
    }

}
