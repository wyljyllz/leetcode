package leetcode.medium.recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName LetterCombinations
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class LetterCombinations {
    /**
     * @description:使用回溯遍历所有结果
     * @author: 卫依伦
     * @date: 2021/11/2
     */
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        HashMap<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    private static void backtrack(ArrayList<String> combinations, HashMap<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {  //结束条件
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);//递归调用
                combination.deleteCharAt(index);//回溯撤销，返回上一层。
            }
        }

    }
}
