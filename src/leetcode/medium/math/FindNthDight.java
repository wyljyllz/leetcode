package leetcode.medium.math;

/**
 * @ClassName FindNthDight
 * @Description TODO数字序列中某一位的数字
 * @Author wyl
 * @Data
 */
public class FindNthDight {
    /**
     * @description:找规律
     * @author: 卫依伦
     * @date: 2021/11/26
     */
    public int findNthDigit(int n) {
        int digit = 1; //位数
        long start = 1; //起始左区间
        long count = 9; //所有值位数和
        while (n > count) { // 1.求出第n位所在数值的位数
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.求第n位所在数值
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.返回所在数值的某位
    }
}
