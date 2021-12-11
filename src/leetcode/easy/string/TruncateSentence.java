package leetcode.easy.string;

/**
 * @ClassName TruncateSentence
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class TruncateSentence {
    /**
     * @description:模拟
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public String truncateSentence(String s, int k) {
        int n = s.length(), idx = 0;
        while (idx < n) {
            if (s.charAt(idx) == ' ' && --k == 0) break;//短路与
            idx++;
        }
        return s.substring(0, idx);
    }

    /**
     * @description:遍历
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public String truncateSentence01(String s, int k) {
        int n = s.length();
        int end = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n || s.charAt(i) == ' ') {
                count++;
                if (count == k) {
                    end = i;
                    break;
                }
            }
        }
        return s.substring(0, end);
    }



}
