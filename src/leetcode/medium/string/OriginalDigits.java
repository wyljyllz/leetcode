package leetcode.medium.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName OriginalDigits
 * @Description 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 * @Author wyl
 * @Data
 */
public class OriginalDigits {
        public String originalDigits(String s) {
            Map<Character, Integer> c = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                c.put(ch, c.getOrDefault(ch, 0) + 1);
            }

            int[] cnt = new int[10];
            cnt[0] = c.getOrDefault('z', 0);
            cnt[2] = c.getOrDefault('w', 0);
            cnt[4] = c.getOrDefault('u', 0);
            cnt[6] = c.getOrDefault('x', 0);
            cnt[8] = c.getOrDefault('g', 0);

            cnt[3] = c.getOrDefault('h', 0) - cnt[8];
            cnt[5] = c.getOrDefault('f', 0) - cnt[4];
            cnt[7] = c.getOrDefault('s', 0) - cnt[6];

            cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

            cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

            StringBuffer ans = new StringBuffer();
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < cnt[i]; ++j) {
                    ans.append((char) (i + '0'));
                }
            }
            return ans.toString();
        }

}
