package leetcode.easy.string;

/**
 * @ClassName ReversEleftWords
 * @Description  左旋转字符串
 * @Author wyl
 * @Data
 */
public class ReversEleftWords {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    /**
     * @description:求余遍历
     * @author: 卫依伦
     * @date: 2021/11/28
     */
    public String reverseLeftWords02(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }


}
