package leetcode.medium.string.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapSum
 * @Description 单词之和
 * @Author wyl
 * @Data
 */
public class MapSum {
    /**
     * @description:暴力扫描
     * @author: 卫依伦
     * @date: 2021/12/11
     */
    class MapSum01 {
        Map<String, Integer> map;

        public MapSum01() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key,val);
        }

        public int sum(String prefix) {
            int res = 0;
            for (String s : map.keySet()) {
                if (s.startsWith(prefix)) {
                    res += map.get(s);
                }
            }
            return res;
        }
    }

    /**
     * @description:前缀哈希映射
     * @author: 卫依伦
     * @date: 2021/12/11
     */
    class MapSum02 {
        Map<String, Integer> map;
        Map<String, Integer> prefixmap;

        public MapSum02() {
            map = new HashMap<>();
            prefixmap = new HashMap<>();
        }

        public void insert(String key, int val) {
            int delta = val - map.getOrDefault(key, 0);//对应的值的增加，差值
            map.put(key, val);
            for (int i = 1; i <= key.length(); ++i) {
                String currprefix = key.substring(0, i);
                prefixmap.put(currprefix, prefixmap.getOrDefault(currprefix, 0) + delta);
            }
        }

        public int sum(String prefix) {
            return prefixmap.getOrDefault(prefix, 0);
        }
    }
    /**
     * @description:前缀树（字典树）
     * @author: 卫依伦
     * @date: 2021/12/11
     */
    class MapSum03 {
        class TrieNode {
            int val = 0;
            TrieNode[] next = new TrieNode[26];
        }

        TrieNode root;
        Map<String, Integer> map;

        public MapSum03() {
            root = new TrieNode();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            int delta = val - map.getOrDefault(key, 0);
            map.put(key, val);
            TrieNode node = root;
            for (char c : key.toCharArray()) { //更新字典树
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
                node.val += delta;
            }
        }

        public int sum(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) { //查找相应前缀
                if (node.next[c - 'a'] == null) {
                    return 0;
                }
                node = node.next[c - 'a'];
            }
            return node.val;
        }
    }


}
