import java.util.ArrayList;
import java.util.List;

public class RemoveOuterParentheses {

    public static void main(String[] args) {
        removeOuterParentheses("(()())(())");
    }

    public static String removeOuterParentheses(String S) {
        StringBuilder builder = new StringBuilder();
        List<Character> list = new ArrayList<>();
        int l = 0;
        int r = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            list.add(c);
            if (c == '(') l++;
            if (c == ')') r++;
            if (l == r) {
                list.remove(0);
                list.remove(list.size() - 1);
                while (!list.isEmpty()) {
                    builder.append(list.remove(0));
                }
                l = 0;
                r = 0;
            }
        }
        return builder.toString();
    }
}
