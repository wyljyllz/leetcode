package leetcode.easy.string;

/**
 * @ClassName CanConstruct
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class CanConstruct {
    /**
     * @description:字符遍历
     * @author: 卫依伦
     * @date: 2021/12/4
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];//数组存储个数
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
