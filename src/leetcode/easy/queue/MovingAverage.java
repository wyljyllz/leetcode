package leetcode.easy.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MovingAverage
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class MovingAverage {
    /**
     * @description:队列
     * @author: 卫依伦
     * @date: 2021/12/7
     */
    private int length;
    private Queue<Integer> queue;
    private double sum = 0;


    public MovingAverage(int size) {
        length = size;
        queue = new LinkedList<>();
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() == length) {
            sum -= queue.remove();//获取并移除此列表的头（第一个元素）。
        }
        queue.add(val);
        sum += val;
        return sum / queue.size();
    }


}
