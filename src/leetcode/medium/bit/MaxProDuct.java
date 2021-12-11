package leetcode.medium.bit;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MaxProDuct
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class MaxProDuct {
    /**
     * @description:位运算判断是否有重复元素
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');//使用位掩码的最低 26位分别表示每个字母是否在这个单词中出现
            }
        }
        int maxProd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((masks[i] & masks[j]) == 0) {//没有公共字母
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }

    /**
     * @description:位运算优化，减少重复计算
     * 使用哈希表记录每个位掩码对应的最大单词长度
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    public int maxProduct01(String[] words) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            int mask = 0;
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                mask |= 1 << (word.charAt(j) - 'a');
            }
            if (wordLength > map.getOrDefault(mask, 0)) {
                map.put(mask, wordLength);
            }
        }
        int maxProd = 0;
        Set<Integer> maskSet = map.keySet();
        for (int mask1 : maskSet) {
            int wordLength1 = map.get(mask1);
            for (int mask2 : maskSet) {
                if ((mask1 & mask2) == 0) {
                    int wordLength2 = map.get(mask2);
                    maxProd = Math.max(maxProd, wordLength1 * wordLength2);
                }
            }
        }
        return maxProd;
    }

}
