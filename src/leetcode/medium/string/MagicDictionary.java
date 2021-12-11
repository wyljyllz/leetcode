package leetcode.medium.string;

import java.util.*;

/**
 * @ClassName MagicDictionary
 * @Description 广义的字典
 * @Author wyl
 * @Data
 */
public class MagicDictionary {
    /**
     * @description:暴力
     * @author: 卫依伦
     * @date: 2021/12/11
     */
    class MagicDictionary01 {
        Map<Integer, ArrayList<String>> buckets;
        public MagicDictionary01() {
            buckets = new HashMap();
        }

        public void buildDict(String[] words) {
            for (String word: words) {
                buckets.computeIfAbsent(word.length(), x -> new ArrayList()).add(word);//若key对应的value为空，会将第二个参数的返回值存入并返回，存在，返回对应value
            }
        }

        public boolean search(String word) {
            if (!buckets.containsKey(word.length())) return false;
            for (String candidate: buckets.get(word.length())) {
                int mismatch = 0;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) != candidate.charAt(i)) {
                        if (++mismatch > 1) break;
                    }
                }
                if (mismatch == 1) return true;
            }
            return false;
        }
    }

    /**
     * @description:广义邻居
     * @author: 卫依伦
     * @date: 2021/12/11
     */
    public class MagicDictionary02{
        Set<String> words;
        Map<String, Integer> count;

        public MagicDictionary02() {
            words = new HashSet();
            count = new HashMap();
        }

        private ArrayList<String> generalizedNeighbors(String word) {//生成广义邻居
            ArrayList<String> ans = new ArrayList();
            char[] ca = word.toCharArray();
            for (int i = 0; i < word.length(); ++i) {
                char letter = ca[i];
                ca[i] = '*';
                String magic = new String(ca);
                ans.add(magic);
                ca[i] = letter;
            }
            return ans;
        }

        public void buildDict(String[] words) {
            for (String word: words) {
                this.words.add(word);
                for (String nei: generalizedNeighbors(word)) {
                    count.put(nei, count.getOrDefault(nei, 0) + 1);
                }
            }
        }

        public boolean search(String word) {
            for (String nei: generalizedNeighbors(word)) {
                int c = count.getOrDefault(nei, 0);
                if (c > 1 || c == 1 && !words.contains(word)) return true;//如果有 2 个或更多，说明字典中肯定存在两个不同的字符，
                // 这两个字符互为广义邻居，且和查找字符也是广义邻居，由于字典中的单词是不重复的。如果只有一个，应该检查是否重复
            }
            return false;
        }
    }

}
