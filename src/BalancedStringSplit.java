import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedStringSplit {

    public int balancedStringSplit(String s) {
        int ret = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(curChar);
            } else if (curChar == stack.peek()) {
                stack.push(curChar);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    ret++;
                }
            }
        }
        return ret;
    }
}
