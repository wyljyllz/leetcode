package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 给定一个数组和目标数，返回两个数的索引
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i}; //nums[i]之前已经添加，nums[i] = target - nums[j];
            }
            map.put(target - nums[i], i);//放入map
//            if (map.containsKey(target - nums[i])) {
//                return new int []{map.get(target- nums[i]), i} //之前放入了
//            }
//            map.put(nums[i], i);
        }
        return null;
    }
}
