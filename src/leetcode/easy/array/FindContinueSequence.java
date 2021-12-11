package leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FindContinueSequence
 * @Description 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * @Author wyl
 * @Data
 */
public class FindContinueSequence {
    /**
     * @description:枚举+暴力
     * @author: 卫依伦
     * @date: 2021/11/28
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<>();
        int sum = 0, limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整
        for (int i = 1; i <= limit; ++i) {
            for (int j = i; ; ++j) {
                sum += j;
                if (sum > target) {//重置
                    sum = 0;
                    break;
                } else if (sum == target) {
                    int[] res = new int[j - i + 1]; //赋值
                    for (int k = i; k <= j; ++k) {
                        res[k - i] = k;
                    }
                    vec.add(res);
                    sum = 0;
                    break;
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    /**
     * @description:数学优化
     * @author: 卫依伦
     * @date: 2021/11/28
     */
    public int[][] findContinuousSequence01(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        int sum = 0, limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整
        for (int x = 1; x <= limit; ++x) {
            long delta = 1 - 4 * (x - (long) x * x - 2 * target);
            if (delta < 0) {
                continue;
            }
            int delta_sqrt = (int) Math.sqrt(delta + 0.5);
            if ((long) delta_sqrt * delta_sqrt == delta && (delta_sqrt - 1) % 2 == 0) {
                int y = (-1 + delta_sqrt) / 2; // 另一个解(-1-delta_sqrt)/2必然小于0，不用考虑
                if (x < y) {
                    int[] res = new int[y - x + 1];
                    for (int i = x; i <= y; ++i) {
                        res[i - x] = i;
                    }
                    vec.add(res);
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    /**
     * @description:双指针，滑动窗口
     * @author: 卫依伦
     * @date: 2021/11/28
     */
    public int[][] findContinuousSequence02(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }
}
