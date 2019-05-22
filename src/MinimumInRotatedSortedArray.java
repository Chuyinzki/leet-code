public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMinInRotatedSortedArray(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    public static int findMinInRotatedSortedArray(int[] rotatedArray) {
        for (int i = 0; i < rotatedArray.length - 1; i++)
            if (rotatedArray[i + 1] < rotatedArray[i])
                return rotatedArray[i + 1];
        return rotatedArray[0];
    }
}
