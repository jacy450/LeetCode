package class06;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int row = 0;
        boolean flag = false;

        for (char ch : s.toCharArray()) {
            rows.get(row).append(ch);
            if (row == 0 || row == numRows - 1) {
                flag = !flag;
            }
            row += flag ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : rows) {
            res.append(sb);
        }
        return res.toString();
    }
}
