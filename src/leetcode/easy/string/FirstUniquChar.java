package leetcode.easy.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassName FirstUniquChar
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class FirstUniquChar {
    public char firstUniqChar(String s) {
    Map<Character, Integer> position = new HashMap<Character, Integer>();
    Queue<Pair> queue = new LinkedList<Pair>();
    int n = s.length();
        for (int i = 0; i < n; ++i) {
        char ch = s.charAt(i);
        if (!position.containsKey(ch)) {
            position.put(ch, i);
            queue.offer(new Pair(ch, i));
        } else {
            position.put(ch, -1);
            while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                queue.poll();
            }
        }
    }
        return queue.isEmpty() ? ' ' : queue.poll().ch;
}

class Pair {
    char ch;
    int pos;

    Pair(char ch, int pos) {
        this.ch = ch;
        this.pos = pos;
    }
}

}
