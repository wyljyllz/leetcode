package leetcode.easy.array.sort;

import java.util.PriorityQueue;

/**
 * @ClassName KthLargest
 * @Description 数据流中的第 K 大元素
 * @Author wyl
 * @Data
 */
public class KthLargest {
    PriorityQueue<Integer> pq;//默认最小堆，一个基于优先级堆的无界优先级队列
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }


}
