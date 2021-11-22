package leetcode.medium.string.statemachine;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName IsNumber实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class IsNumber {
    public static java.util.regex.Pattern P = java.util.regex.Pattern.compile("\\s*[+-]?((\\d*\\.?\\d+)|(\\d+\\.?))([eE][+-]?\\d+)?\\s*");

    /**
     * @description:通过异常进行判断
     * @author: 卫依伦
     * @date: 2021/11/21
     */
    public boolean isNumber01(String s) {
        if(s == null || s.length() == 0){
            return false;
        }

        //面向测试用例编程，末尾有空格算数字？不解
        s = s.trim();
        try{
            double a = Double.parseDouble(s);
        }catch (Exception e){
            return false;
        }

        char c = s.charAt(s.length()-1);
        //特，末尾有f，d,D这些不算，但是3.算数字（面向测试用例编程）
        return (c >= '0' && c <= '9') || c == '.';
    }

    /**
     * @description:状态机
     * @author: 卫依伦
     * @date: 2021/11/21
     */
        public boolean isNumber02(String s) {
            Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();
            Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_SPACE, State.STATE_INITIAL);
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
                put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
            }};
            transfer.put(State.STATE_INITIAL, initialMap);
            Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            }};
            transfer.put(State.STATE_INT_SIGN, intSignMap);
            Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_POINT, State.STATE_POINT);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_INTEGER, integerMap);
            Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_POINT, pointMap);
            Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            }};
            transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
            Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_FRACTION, fractionMap);
            Map<CharType, State> expMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
                put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
            }};
            transfer.put(State.STATE_EXP, expMap);
            Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            }};
            transfer.put(State.STATE_EXP_SIGN, expSignMap);
            Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_EXP_NUMBER, expNumberMap);
            Map<CharType, State> endMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_END, endMap);

            int length = s.length();
            State state = State.STATE_INITIAL;

            for (int i = 0; i < length; i++) {
                CharType type = toCharType(s.charAt(i));
                if (!transfer.get(state).containsKey(type)) {
                    return false;
                } else {
                    state = transfer.get(state).get(type);
                }
            }
            return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
        }

        public CharType toCharType(char ch) {
            if (ch >= '0' && ch <= '9') {
                return CharType.CHAR_NUMBER;
            } else if (ch == 'e' || ch == 'E') {
                return CharType.CHAR_EXP;
            } else if (ch == '.') {
                return CharType.CHAR_POINT;
            } else if (ch == '+' || ch == '-') {
                return CharType.CHAR_SIGN;
            } else if (ch == ' ') {
                return CharType.CHAR_SPACE;
            } else {
                return CharType.CHAR_ILLEGAL;
            }
        }
        enum State {
            STATE_INITIAL,
            STATE_INT_SIGN,
            STATE_INTEGER,
            STATE_POINT,
            STATE_POINT_WITHOUT_INT,
            STATE_FRACTION,
            STATE_EXP,
            STATE_EXP_SIGN,
            STATE_EXP_NUMBER,
            STATE_END
        }

        enum CharType {
            CHAR_NUMBER,
            CHAR_EXP,
            CHAR_POINT,
            CHAR_SIGN,
            CHAR_SPACE,
            CHAR_ILLEGAL
        }


    /**
     * @description:正则表达式
     * @author: 卫依伦
     * @date: 2021/11/21
     */
    public boolean isNumber(String s) {
        return P.matcher(s).matches();
    }
}
