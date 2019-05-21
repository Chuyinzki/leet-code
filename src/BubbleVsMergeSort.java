import java.util.Arrays;
import java.util.Random;

public class BubbleVsMergeSort {
    public static void main(String[] args) {
        int[] toSort = new int[100000];
        Random rand = new Random();
        for(int i = 0; i < toSort.length; i++) {
            toSort[i] = rand.nextInt(toSort.length);
        }
        int[] toSort2 = Arrays.copyOf(toSort, toSort.length);
        long start1 = System.currentTimeMillis();
        BubbleSort.bubbleSort(toSort);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        MergeSort.mergeSort(toSort2);
        long end2 = System.currentTimeMillis();

        System.out.printf("Bubble sort took %d ms\n", end1 - start1);
        System.out.printf("Merge sort took %d ms\n", end2 - start2);
    }
}
