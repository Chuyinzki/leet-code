import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // --> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      // --> Returns 0.
        System.out.println(minStack.getMin());  //  --> Returns -2.
    }

    private ArrayList<Integer> minList = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();

    // Push element x onto stack.
    void push(int x) {
        stack.push(x);
        minList.add(x);
        Collections.sort(minList);
    }

    // Removes the element on top of the stack.
    int pop() {
        Integer toRemove = stack.pop();
        minList.remove(toRemove);
        return toRemove;
    }

    // Get the top element.
    int top() {
        return stack.peek();
    }

    // Retrieve the minimum element in the stack.
    int getMin() {
        return minList.get(0);
    }
}
