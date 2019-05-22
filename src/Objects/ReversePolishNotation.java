package Objects;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        System.out.print(reversePolishNotation(new String[]{"2", "1", "+", "3", "*"}));
    }

    public static int reversePolishNotation(String[] todo) {
        Stack<Integer> numbers = new Stack<>();
        for (String nextString : todo) {
            if (!Character.isDigit(nextString.charAt(0))) {
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
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else if (op == '/') return a / b;
        else //op == '*'
            return a * b;
    }
}
