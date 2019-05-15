public class DailyTemperatures {
    public static void main(String[] args) {
        //T = [73, 74, 75, 71, 69, 72, 76, 73] -> [1, 1, 4, 2, 1, 1, 0, 0]
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    public static int[] dailyTemperatures(int[] T) {
        for (int i = 0; i < T.length - 1; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    T[i] = j - i;
                    break;
                }
                if (j + 1 == T.length) T[i] = 0;
            }
        }
        T[T.length - 1] = 0;
        return T;
    }
}
