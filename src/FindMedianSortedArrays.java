/*
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        findMedianSortedArrays(nums1, nums2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int index1 = 0;
        int index2 = 0;
        Integer capture = null;
        int halfway = totalLength / 2;
        boolean isOdd = totalLength % 2 == 1;
        for(int i = 0; i < halfway; i++) {
            if(nums1[index1] < nums2[index2]) {
                index1++;
                if(i == halfway - 1) {
                    capture = nums1[index1];
                }
            }
            else {
                index2++;
                if(i == halfway - 1) {
                    capture = nums2[index2];
                }
            }
        }
        return Double.valueOf(capture);
    }

}
*/
