public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            for(int j = 0; j < nums.length; j++) {
                if(j == i) continue;
                if(curNum == nums[j]) return curNum;
            }
        }
        return -1;
    }
}
