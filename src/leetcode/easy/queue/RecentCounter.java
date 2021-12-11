package leetcode.easy.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName RecentCounter
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q = new LinkedList();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }

}
