package stack.RemoveOutermostParentheses;

import org.junit.Test;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int level = 0;
        for(char ch : s.toCharArray()) {
            if(ch == ')') level--;
            if(level >= 1) stringBuilder.append(ch);
            if(ch == '(') ++level;
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}
