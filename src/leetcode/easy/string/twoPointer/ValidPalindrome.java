package leetcode.easy.string.twoPointer;

/**
 * @ClassName ValidPalindrome
 * @Description 删掉一个字符是否是回文字符串
 * @Author wyl
 * @Data
 */
public class ValidPalindrome {
    /**
     * @description:贪心，双指针
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    public boolean validPalindrome01(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                ++low;
                --high;
            } else {
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }
        }
        return true;
    }

    private boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

    /**
     * @description:递归
     * @author: 卫依伦
     * @date: 2021/12/6
     */
    int del = 0;  //记录删除的字符次数
    public boolean validPalindrome(String s) {
        int i = 0,j = s.length()-1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                //不相等的话，若没有删除字符，则删除左边或右边的字符再判断；若删除过一次，则不是回文串
                if(del == 0){
                    del++;
                    return validPalindrome(s.substring(i,j)) || validPalindrome(s.substring(i+1,j+1));
                }
                return false;
            }
        }
        return true;
    }
}
