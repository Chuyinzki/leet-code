import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            if(complements.get(curNum) != null)
                return new int[]{complements.get(curNum), i};
            complements.put(target - curNum, i);
        }
        return null;
    }
}
