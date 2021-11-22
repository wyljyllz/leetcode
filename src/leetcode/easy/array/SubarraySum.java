package leetcode.easy.array;

import java.util.HashMap;

/**
 * @ClassName 给定一个整数数组和一个整数targetSum，找到该数组中和为 k的连续的子数组的个数。
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class SubarraySum {
    /**
     * @description:使用前缀和
     * @author: 卫依伦
     * @date: 2021/10/3
     */
    public static int subarraySum(int[] nums, int targetSum) {
        int n = nums.length;
        int count = 0;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        for (int i = 0; i < n; i ++) {
            for (int j = -1; j < i; j++) {
                int sumOfSub;
                if (j < 0)
                    sumOfSub = sum[i];//j等于-1时，完整前缀和
                else
                    sumOfSub = sum[i] - sum[j];
                if (sumOfSub == targetSum)
                    count++;
            }
        }
        return count;
    }
    /**
     * @description:前缀和和哈希
     * 使用到了前面的前缀和，所以使用哈希存储
     * @author: 卫依伦
     * @date: 2021/10/3
     */
    public static int subarraySum01(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);//前缀和刚好等于给定的数
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre,0) + 1);
            //getOrDefault,有这个key时，就返回这个key对应的value值
            //如果没有就使用默认值defaultValue
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr ={1,1,1,1,1,1};
        int i = subarraySum01(arr, 2);
        System.out.println(i);
    }
}
