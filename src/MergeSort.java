public class MergeSort {
    public static void main(String[] args) {
        for (int i : mergeSort(new int[]{3, 6, 2, 7, 12, 9, 11, 5, 10, 12})) {
            System.out.print(i + ", ");
        }
    }

    // 1. Split down to minimum size
    // 2. Merge them back
    public static int[] mergeSort(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums;
        int[] nums1 = new int[nums.length / 2];
        int[] nums2 = new int[nums.length - nums1.length];
        int i = 0;
        int k = 0;
        while (i < nums1.length)
            nums1[k++] = nums[i++];
        int j = 0;
        while (i < nums.length)
            nums2[j++] = nums[i++];

        return merge(mergeSort(nums1), mergeSort(nums2));
    }

    public static int[] merge(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length + nums2.length];
        int nums1Pointer = 0, nums2Pointer = 0;
        int i = 0;
        while (nums1Pointer < nums1.length && nums2Pointer < nums2.length) {
            ret[i++] = nums1[nums1Pointer] < nums2[nums2Pointer] ? nums1[nums1Pointer++] : nums2[nums2Pointer++];
        }
        if (nums1Pointer == nums1.length) {
            while (nums2Pointer < nums2.length) ret[i++] = nums2[nums2Pointer++];
        } else {
            while (nums1Pointer < nums1.length) ret[i++] = nums1[nums1Pointer++];
        }
        return ret;
    }

}
