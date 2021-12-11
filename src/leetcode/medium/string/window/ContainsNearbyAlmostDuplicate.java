package leetcode.medium.string.window;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @ClassName ContainsNearbyAlmostDuplicate
 * @Description 存在重复元素
 * @Author wyl
 * @Data
 */
public class ContainsNearbyAlmostDuplicate {
    /**
     * @description:滑动窗口+有序集合，维护一个长度为k的窗口
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);//方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {//nums[i] - t <= nums[j] <= nums[i] + t 
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    /**
     * @description:桶排序
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    public boolean containsNearbyAlmostDuplicate01(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<Long, Long>();
        long w = (long) t + 1;
        for (int i = 0; i < n; i++) {
            long id = getID(nums[i], w);
            if (map.containsKey(id)) {//一旦要覆盖，就说明存在两个元素同属一个桶，直接返回true了
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    public long getID(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;//保证正负元素桶对应，-1成-0
    }
}
