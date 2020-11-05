package stack.ValidParentheses;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new LinkedList<Character>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(')');
            } else if(ch == '[') {
                stack.push(']');
            } else if(ch == '{') {
                stack.push('}');
            } else if(stack.isEmpty() || ch != stack.peek()) {
                return false;
            } else {
                stack.pop();
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
