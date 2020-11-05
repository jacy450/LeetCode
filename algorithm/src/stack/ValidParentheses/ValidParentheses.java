package stack.ValidParentheses;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();

//      当遇到左括号，向栈中添加对应的右括号
//      如果遇到右括号，那么就与栈顶元素对比
//      相同: 出栈
//      不相同：则说明不匹配

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || ch != stack.peek()) {
                return false;
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        System.out.println(isValid("{}"));
    }
}
