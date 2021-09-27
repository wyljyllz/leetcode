package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName 求三数之和
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class ThreeSum {

    /**
     * @description:排序和使用双指针，
     * @author: 卫依伦
     * @date: 2021/11/1
     */
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;
        Arrays.sort(nums);//排序
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;//如果第一个数大于0，肯定不成立
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去掉重复情况
            int target = -nums[i];
            int left = i + 1,right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
    /**
     * @description:参考两数之和，排序。
     * @author: 卫依伦
     * @date: 2021/11/1
     */
    public List<List<Integer>> threeSum01(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);//排序
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;//之后都大于0，不符合
            Integer first = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重
            HashSet<Object> set = new HashSet<>(); //去重第二个元素
            for (int j = i + 1; j < nums.length; j++) {
                int third = nums[j];//此时的元素
                int second = - (first + third);//目标元素；
                if (set.contains(second)) { //判断是否set中之前是否添加有目标元素
                    lists.add(Arrays.asList(first,second, third));
                    while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
                }
                set.add(third);
            }
        }
        return lists;
    }
}
