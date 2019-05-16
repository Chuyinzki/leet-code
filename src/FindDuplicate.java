public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int i = 0, j = 0;
        int intersection = 0;
        while (true) {
            i = nums[i];
            j = nums[j];
            j = nums[j];
            if (nums[i] == nums[j]){
                i = 0;
                break;
            }
        }
        while(true) {
            if(nums[i] == nums[j])
                return nums[j];
            i = nums[i];
            j = nums[j];
        }
    }
}
