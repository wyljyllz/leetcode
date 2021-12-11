package leetcode.medium.string;

/**
 * @ClassName CountSubstring
 * @Description 回文子字符串的个数
 * @Author wyl
 * @Data
 */
public class CountSubstring {

    /**
     * @description:中心拓展
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {//一次循环
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

    public int countSubstrings01(String s) {
        int n = s.length(), ans = 0;
        char[] s1 = s.toCharArray();
        for (int i = 0; i < n ; ++i) {
            for(int j=0;j<=1;j++)//j=0,中心是一个点，j=1,中心是两个点
            {
                int l = i;
                int r = i+j;
                while(l>=0 && r<n && s1[l--]==s1[r++])
                    ans++;
            }
        }
        return ans;
    }
    /**
     * @description:Manacher 算法
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public int countSubstrings02(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }

    /**
     * @description:动态规划
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public int countSubstrings03(String s) {
        int ans = 0;
        boolean[][] dp =  new boolean[s.length()][s.length()];
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 1){
                        dp[i][j] = true;
                        ans++;
                    }else if(dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
