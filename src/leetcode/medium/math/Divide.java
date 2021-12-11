package leetcode.medium.math;

/**
 * @ClassName Divide
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class Divide {
    /**
     * @description:二分
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    public int divide(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }

        // 一般情况，使用二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            // 注意溢出，并且不能使用乘法
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(divisor, mid, dividend);
            if (check) {
                ans = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rev ? -ans : ans;
    }

    // 快速乘
    public boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }

    /**
     * @description:
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    // 100/3
// 100>3 100>6 100>12 100>24 100>48 100>96 100<192 ---- 使用了 2^5 = 32 个3，还剩 100 - 96 = 4 需要被除
// 4>3 4<6                                         ---- 使用了 2^0 = 1  个3，还剩 4   - 3  = 1 需要被除
// 1<3                                             ---- 被除数小于除数，递归结束，总计使用了 33 个 3
    class Solution {
        public int divide(int dividend, int divisor) {
            // 当除数为1，直接返回被除数
            if (divisor == 1) {
                return dividend;
            }
            // 当除数为-1且被除数为Integer.MIN_VALUE时，将会溢出，返回Integer.MAX_VALUE
            if (divisor == -1 && dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }

            // 把被除数与除数调整为正数,为防止被除数Integer.MIN_VALUE转换为正数会溢出，使用long类型保存参数
            if (dividend < 0 && divisor < 0) {
                return divide(-(long) dividend, -(long) divisor);
            } else if (dividend < 0 || divisor < 0) {
                return -divide(Math.abs((long) dividend), Math.abs((long) divisor));
            } else {
                return divide((long) dividend, (long) divisor);
            }
            //或者用异或判断
        }

        public int divide(long dividend, long divisor) {
            // 如果被除数小于除数，结果明显为0
            if (dividend < divisor) {
                return 0;
            }
            long sum = divisor; // 记录用了count个divisor的和
            int count = 1; // 使用了多少个divisor
            while (dividend >= sum) {
                // 每次翻倍
                sum <<= 1;
                count <<= 1;
            }
            // 此时dividend < sum
            sum >>>= 1;
            count >>>= 1;
            // 此时dividend >= sum
            // 将count个divisor从dividend消耗掉，剩下的还需要多少个divisor交由递归函数处理
            return count + divide(dividend - sum, divisor);
        }
    }

    /**
     * @description:位运算
     * @author: 卫依伦
     * @date: 2021/12/3
     */
    public int divide01(int dividend, int divisor) {
        // 当除数为1，直接返回被除数
        if (divisor == 1) {
            return dividend;
        }
        // 当除数为-1且被除数为Integer.MIN_VALUE时，将会溢出，返回Integer.MAX_VALUE
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int n = 0;
        for (int i = 31; i >= 0; i--) {
            // 首先，右移的话，再怎么着也不会越界
            // 其次，无符号右移的目的是：当最小值时a = 2147483648,
//            a >> 1 = -1073741824
//            a >>> 1 = 1073741824

            // 注意，这里不能是 (a >>> i) >= b 而应该是 (a >>> i) - b >= 0
            // 这个也是为了避免 b = -2147483648，如果 b = -2147483648
            // 那么 (a >>> i) >= b 永远为 true，但是 (a >>> i) - b >= 0 为 false
            if ((dividend >>> i) - divisor>= 0) {
                dividend -= (divisor << i);
                n += (1 << i);
            }
        }
        return sign == 1 ? n : -n;
    }
}
