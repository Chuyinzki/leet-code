public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fibRec(2));
    }

    public static int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i < N; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return first + second;
    }

    public static int fibRec(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return fibRec(N - 1) + fibRec(N - 2);
    }
}
