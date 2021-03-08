package class07;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    private class Automaton {
        public int sign = 1;
        public long ans = 0;

        private String state = "start";

        private Map<String, String[]> map = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char ch) {
            state = map.get(state)[get_col(ch)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + ch - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = ch == '+' ? 1 : -1;
            }
        }

        private int get_col(char ch) {
            if (ch == ' ') {
                return 0;
            }
            if (ch == '+' || ch == '-') {
                return 1;
            }
            if (Character.isDigit(ch)) {
                return 2;
            }
            return 3;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.myAtoi("4193 with words");
        System.out.println(i);
    }
}
