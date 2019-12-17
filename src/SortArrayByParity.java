public class SortArrayByParity {

    public static void main(String[] args) {
        sortArrayByParity(new int[]{0, 1, 3, 5, 2});
    }

    public static int[] sortArrayByParity(int[] A) {
        int j = A.length - 1;
        for (int i = 0; i < j; i++) {
            while (j > 0 && A[j] % 2 == 1) {
                j--;
            }
            if (j == 0 || j < i) {
                break;
            }
            if (A[i] % 2 == 1) {
                int temp = A[j];
                A[j--] = A[i];
                A[i] = temp;
            }
        }
        return A;
    }
}
