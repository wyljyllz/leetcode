package leetcode.easy.string;

/**
 * @ClassName DetectCapitalUse检验是否是正确的大写单词
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0))  && Character.isUpperCase(word.charAt(1))) {
            return false;
        }
        for (int i = 2; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) { //异或操作
                return false;
            }
        }
        return true;
    }
}
