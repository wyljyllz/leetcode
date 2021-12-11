package leetcode.medium.other;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @ClassName MyCalendar
 * @Description 日程表
 * @Author wyl
 * @Data
 */
public class MyCalendar {
    /**
     * @description:暴力
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    public class MyCalendar01 {
        List<int[]> calendar;

        MyCalendar01() {
            calendar = new ArrayList();
        }

        public boolean book(int start, int end) {
            for (int[] iv: calendar) {
                if (iv[0] < end && start < iv[1]) return false;
            }
            calendar.add(new int[]{start, end});
            return true;
        }
    }

    /**
     * @description:TreeMap
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    class MyCalendar02 {
        TreeMap<Integer, Integer> calendar;

        MyCalendar02() {
            calendar = new TreeMap();
        }

        public boolean book(int start, int end) {
            Integer prev = calendar.floorKey(start),//用于返回小于或等于给定键元素(key_ele)的最大键元素(如果存在)，否则，当不存在该键元素时返回null。
                    next = calendar.ceilingKey(start);//返回最小键大于或等于返回到给定的键，或null
            if ((prev == null || calendar.get(prev) <= start) &&//数学数轴
                    (next == null || end <= next)) {
                calendar.put(start, end);
                return true;
            }
            return false;
        }
    }


}
