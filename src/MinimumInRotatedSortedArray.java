public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMinInRotatedSortedArray(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    public static int findMinInRotatedSortedArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i + 1] < nums[i])
                return nums[i + 1];
        return nums[0];
    }
}
