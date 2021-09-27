package leetcode.medium;

import java.sql.Array;
import java.util.ArrayList;

/**
 * @ClassName z字形变化
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class zConvet {
    public String zonvert(String s, int numsRows) {
        if (numsRows == 1) {
            return s;
        }
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numsRows, s.length()); i++) {
            rows.add(new StringBuilder());//先新建
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);//添加
            if (curRow == 0 || curRow == numsRows - 1)
                goingDown = !goingDown;//在第一行或者最后一行，需要换方向
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows)
            ret.append(row);
        return ret.toString();

    }
}
