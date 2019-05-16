import java.util.HashMap;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        final int majority = nums.length/2 + 1;
        HashMap<Integer, Integer> numTimes = new HashMap<>();
        for(int i : nums) {
            Integer times = numTimes.get(i);
            if(times == null) {
                times = 0;
            }
            numTimes.put(i, ++times);
            if(times == majority) return i;
        }
        return -1;
    }
}
