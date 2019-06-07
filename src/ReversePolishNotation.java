import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        System.out.print(reversePolishNotation(
            new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int reversePolishNotation(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");
        for (String nextString : tokens) {
            if (operators.contains(nextString)) {
                Integer second = numbers.pop();
                Integer first = numbers.pop();
                numbers.add(doArithmetic(first, nextString.charAt(0), second));
            } else {
                numbers.add(Integer.parseInt(nextString));
            }
        }
        return numbers.pop();
    }

    private static int doArithmetic(int a, char op, int b) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '/') {
            return a / b;
        } else //op == '*'
        {
            return a * b;
        }
    }
}
