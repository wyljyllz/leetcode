package leetcode.medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FindMaxLength
 * @Description 0 和 1 个数相同的最长连续子数组
 * @Author wyl
 * @Data
 */
public class FindMaxLength {
    /**
     * @description:前缀和+哈希表
     * @author: 卫依伦
     * @date: 2021/12/5
     */
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter, -1);//从第一个元素开始的正确子串
       // 0代表前一个不存在的元素前缀和为 0, -1 代表不存在元素的索引，为了方便计算结果
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) { //最长，只放第一个
                int preIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - preIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }
}
