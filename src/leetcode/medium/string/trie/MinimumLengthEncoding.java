package leetcode.medium.string.trie;

import java.util.*;

/**
 * @ClassName MinimumLengthEncoding
 * @Description  最短的单词编码
 * @Author wyl
 * @Data
 */
public class MinimumLengthEncoding {

    /**
     * @description:移除前缀
     * @author: 卫依伦
     * @date: 2021/12/11
     */
        public int minimumLengthEncoding(String[] words) {
            Set<String> good = new HashSet<String>(Arrays.asList(words));
            for (String word: words) {
                for (int k = 1; k < word.length(); ++k) {
                    good.remove(word.substring(k));
                }
            }

            int ans = 0;
            for (String word: good) {
                ans += word.length() + 1;
            }
            return ans;
        }
    /**
     * @description:字典树
     * 去找到是否不同的单词具有相同的后缀，我们可以将其反序之后插入字典树中，统计叶子节点代表的单词长度加一的和
     * @author: 卫依伦
     * @date: 2021/12/11
     */
    class Solution {
        public int minimumLengthEncoding(String[] words) {
            TrieNode trie = new TrieNode();
            Map<TrieNode, Integer> nodes = new HashMap<TrieNode, Integer>();

            for (int i = 0; i < words.length; ++i) {
                String word = words[i];
                TrieNode cur = trie;
                for (int j = word.length() - 1; j >= 0; --j) {
                    cur = cur.get(word.charAt(j));
                }
                nodes.put(cur, i);
            }

            int ans = 0;
            for (TrieNode node: nodes.keySet()) {
                if (node.count == 0) { //此时是叶子结点时
                    ans += words[nodes.get(node)].length() + 1;
                }
            }
            return ans;

        }
    }

    class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }

        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }


}
