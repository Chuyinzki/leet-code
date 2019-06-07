import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                chars.push(c);
            } else {
                if (chars.isEmpty()) {
                    return false;
                }
                char popped = chars.pop();
                if ((popped == '{' && c != '}') || (popped == '(' && c != ')') || (popped == '['
                    && c != ']')) {
                    return false;
                }
            }
        }
        return chars.isEmpty();
    }
}
