package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 字符串转换为整数
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class MyAtoi {
    /**
     * @description:使用有限状态机
     * @author: 卫依伦
     * @date: 2021/10/31
     */
    public static int myAtoi(String str) {
        AutoMaton autoMaton = new AutoMaton();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            autoMaton.get(str.charAt(i));
        }
        return (int) (autoMaton.sign * autoMaton.ans);
    }
    static class AutoMaton{
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[] {"start", "signed", "in_number", "end"});
            put("signed", new String[] {"end", "end", "in_number", "end"});
            put("in_number", new String[] {"end", "end", "in_number", "end"});
            put("end", new String[] {"end", "end", "end", "end"});
        }};//静态代码块初始化
        public void get(char c) {
            state = table.get(state)[get_col(c)];//获得下一次状态
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';//计算值
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);//判断溢出
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;//判断符号
            }
        }
        private int get_col(char c) {//根据下一个字符判断下一次状态
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }
}
