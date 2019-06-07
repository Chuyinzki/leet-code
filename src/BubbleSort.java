public class BubbleSort {

    public static void main(String[] args) {
        for (int i : bubbleSort(new int[]{3, 6, 2, 7, 12, 9, 11, 5, 10, 12})) {
            System.out.print(i + ", ");
        }
    }

    public static int[] bubbleSort(int[] toSort) {
        int i = toSort.length - 2;
        while (i >= 0) {
            int running = i;
            while (running + 1 < toSort.length && toSort[running] >= toSort[running + 1]) {
                int temp = toSort[running];
                toSort[running] = toSort[running + 1];
                toSort[++running] = temp;
            }
            i--;
        }
        return toSort;
    }
}
