import java.util.ArrayList;

public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        ArrayList<Integer> smallArray = new ArrayList<>(2);
        smallArray.add(0);
        smallArray.add(1);
        for(int i = 2; i < N; i++) {
            smallArray.add(smallArray.remove(0) + smallArray.get(0));
        }
        return smallArray.get(0) + smallArray.get(1);
    }
}
