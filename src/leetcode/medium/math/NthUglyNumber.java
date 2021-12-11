package leetcode.medium.math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName NthUglyNumber
 * @Description 求第n个丑数
 * @Author wyl
 * @Data
 */
public class NthUglyNumber {

    /**
     * @description:最小堆
     * 初始时堆为空。首先将最小的丑数 1 加入堆。
     * 每次取出堆顶元素 x，则 x 是堆中最小的丑数，由于 2x, 3x, 5x也是丑数
     * 因此将 2x, 3x, 5x加入堆。
     * @author: 卫依伦
     * @date: 2021/11/27
     */
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    /**
     * @description:动态规划
     * @author: 卫依伦
     * @date: 2021/11/27
     */
    public int nthUglyNumber01(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
