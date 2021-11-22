package leetcode.difficult;

import java.util.HashMap;

/**
 * @ClassName 给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，
 * 则返回空字符串 "" 。
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class MinWondow {

    public static String mindow(String s1, String s2) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int min = -1, max = -1,Min = Integer.MAX_VALUE;
        String minStr = "";
        if (s1.length() < s2.length()) {
            return "";
        }
        for (int j = 0; j < s1.length(); j++) {
            for (int i = 0; i < s2.length(); i++){
                hash.put(s2.charAt(i),1);
            }
            while(!hash.containsKey(s1.charAt(j)) && j + 1 < s1.length()) {
                j++;
            }
            min = j;
            for (int k = j; k < s1.length(); k++) {
                while(!hash.containsKey(s1.charAt(k)) && k + 1 < s1.length()) {
                    k++;
                }
                hash.put(s1.charAt(k), 0);
                if (adjust(hash,s2)) {
                    max = k ;
                    break;
                }
            }
            if (max - min < Min && max != -1 && min != -1) {
                Min = max - min;
                if(Min < 0)
                { minStr ="";}
                else{minStr = s1.substring(min , max + 1);}
            }
            min = -1;
            max = -1;

        }
        return minStr;
    }

    public static boolean adjust(HashMap hash, String s) {
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if(!hash.get(s.charAt(i)).equals(0)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * @description:滑动窗口
     * @author: 卫依伦
     * @date: 2021/11/7
     */
    public static String minwindow01(String s, String t) {
        // 不考虑 s == null || t == null
        int s_len = s.length(), t_len = t.length();
        if(s_len==0 || t_len==0 || s_len<t_len){
            return "";
        }
        int[] need = new int[128];//ASCII码
        // t 数字需要的字符的类型及个数
        for(int i=0; i<t_len; i++)  need[t.charAt(i)]++;
        int count = t_len, min_value = 100001, min_index=-1;
        int left=0,right=0;
        while(right<s_len){
            char addStr = s.charAt(right);
            if(need[addStr]>0){ //减1的条件，若窗口变动，导致这个大于了0
                count--;
            }
            need[addStr]--;
            //窗口中已经包含所有字符
            if(count==0){
                while(left<right && need[s.charAt(left)]<0){
                    need[s.charAt(left)]++; //释放左边移动出窗口的字符，之前没有的就是负的
                    left++; //左边指针右移
                }
                // 不能右移时候，恰好满足条件
                if(right-left+1 < min_value){
                    min_value = right-left+1;
                    min_index = left;
                }
                //左指针右移，找下一个窗口
                need[s.charAt(left)]++;
                left++;
                count++;
            }
            right++;
        }
        // 返回值是s.substring(min_index, min_index + min_value);
        return min_index==-1 ? "" : s.substring(min_index, min_index + min_value);
    }

    public static void main(String[] args) {
//        HashMap<Character, Integer> s = new HashMap<>();
//        s.put('c', 1);
//        s.put('b', 0);
//        String s1 = "cb";
//        boolean adjust = adjust(s, s1);
//        System.out.println(adjust);
//        String s = "abc";
//        System.out.println(s.substring(0, 3));
        String s = "";
        int length = s.length();
        System.out.println(length);
    }
}
