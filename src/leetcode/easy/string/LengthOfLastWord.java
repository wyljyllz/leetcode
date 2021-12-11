package leetcode.easy.string;

/**
 * @ClassName LengthOfLastWord
 * @Description TODO最后一个单词的长度
 * @Author wyl
 * @Data
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
}
