package leetcode.easy.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName ReverseWords
 * @Description 翻转单词顺序
 * @Author wyl
 * @Data
 */
public class ReverseWords {
    /**
     * @description:双指针倒叙遍历
     * @author: 卫依伦
     * @date: 2021/11/28
     */
        public String reverseWords(String s) {
            s = s.trim(); // 删除首尾空格
            int j = s.length() - 1, i = j;
            StringBuilder res = new StringBuilder();
            while(i >= 0) {
                while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
                res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
                while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
                j = i; // j 指向下个单词的尾字符
            }
            return res.toString().trim(); // 转化为字符串并返回
        }

    /**
     * @description:split+倒叙遍历
     * @author: 卫依伦
     * @date: 2021/11/28
     */
        public String reverseWords01(String s) {
            String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
            StringBuilder res = new StringBuilder();
            for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
                if(strs[i].equals("")) continue; // 遇到空单词则跳过
                res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
            }
            return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
        }

        /**
         * @description:双端队列,API
         * @author: 卫依伦
         * @date: 2021/11/28
         */
        public static String reverseWords02(String s) {
            int left = 0, right = s.length() - 1;
            // 去掉字符串开头的空白字符
            while (left <= right && s.charAt(left) == ' ') {
                ++left;
            }

            // 去掉字符串末尾的空白字符
            while (left <= right && s.charAt(right) == ' ') {
                --right;
            }

            Deque<String> d = new ArrayDeque<String>();
            StringBuilder word = new StringBuilder();

            while (left <= right) {
                char c = s.charAt(left);
                if ((word.length() != 0) && (c == ' ')) { //去多余空格
                    // 将单词 push 到队列的头部
                    d.offerFirst(word.toString());
                    word.setLength(0);//快速清空字符数组
                } else if (c != ' ') {
                    word.append(c);
                }
                ++left;
            }
            d.offerFirst(word.toString()); //最后一个单词

            return String.join(" ", d);
        }

    public static void main(String[] args) {
//        String the_sky_is_blue = reverseWords02("the sky is blue");
//        System.out.println(the_sky_is_blue.toString());
    }
}
