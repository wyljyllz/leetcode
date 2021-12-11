package leetcode.medium.string;

/**
 * @ClassName countAndSay
 * @Description 外观数列
 * @Author wyl
 * @Data
 */
public class countAndSay {
    /**
     * @description:遍历生成
     * @author: 卫依伦
     * @date: 2021/12/1
     */
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuffer sb = new StringBuffer();
            int start = 0;
            int pos = 0;
            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }
        return str;
    }
}
