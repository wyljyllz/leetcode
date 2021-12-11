package leetcode.medium.string.trie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName ReplaceWords
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class ReplaceWords {
    /**
     * @description:前缀哈希
     * 遍历句子中每个单词，查看单词前缀是否为词根。
     * @author: 卫依伦
     * @date: 2021/12/11
     */
    public String replaceWords(List<String> roots, String sentence) {
        Set<String> rootset = new HashSet();
        for (String root: roots) rootset.add(root);

        StringBuilder ans = new StringBuilder();
        for (String word: sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substring(0, i);
                if (rootset.contains(prefix)) break;
            }
            if (ans.length() > 0) ans.append(" ");
            ans.append(prefix);
        }
        return ans.toString();
    }

    /**
     * @description:前缀树
     * @author: 卫依伦
     * @date: 2021/12/11
     */
    public String replaceWords01(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        for (String root: roots) { //构造
            TrieNode cur = trie;
            for (char letter: root.toCharArray()) {
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode();
                cur = cur.children[letter - 'a'];
            }
            cur.word = root;
        }

        StringBuilder ans = new StringBuilder();

        for (String word: sentence.split("\\s+")) { //也就是说它是按空白部分进行拆分，不管这个空白使用什么操作留下
            if (ans.length() > 0)
                ans.append(" ");

            TrieNode cur = trie;//初始
            for (char letter: word.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null)//跳出条件，不符合，或者遍历结束
                    break;
                cur = cur.children[letter - 'a'];//符合的情况
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
    }
}

class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode() {
        children = new TrieNode[26];
    }


}
