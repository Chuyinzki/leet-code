import java.util.Arrays;
import java.util.Random;

public class BubbleVsMergeSort {
    public static void main(String[] args) throws Exception {
        int[] toSort = new int[100000];
        Random rand = new Random();
        for (int i = 0; i < toSort.length; i++) {
            toSort[i] = rand.nextInt(toSort.length);
        }
        int[] toSort2 = Arrays.copyOf(toSort, toSort.length);
        long start1 = System.currentTimeMillis();
        BubbleSort.bubbleSort(toSort);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        toSort2 = MergeSort.mergeSort(toSort2);
        long end2 = System.currentTimeMillis();

        System.out.printf("Bubble sort took %d ms\n", end1 - start1);
        System.out.printf("Merge sort took %d ms\n", end2 - start2);

        for (int i = 0; i < toSort.length; i++)
            if (toSort[i] != toSort2[i])
                throw new Exception("Oh damn, the sorted outputs are not equivalent! Error at i = " + i);
        System.out.println("The lists have finished testing for equivalence.");
    }
}
