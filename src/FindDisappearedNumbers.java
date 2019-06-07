import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {

    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{1, 1});
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> missingInts = new ArrayList<>();
        int lastNum = 0;
        for (int curNum : nums) {
            if (lastNum != curNum) {
                for (int j = lastNum + 1; j < curNum; j++) {
                    missingInts.add(j);
                }
            }
            lastNum = curNum;
        }
        for (int i = lastNum + 1; i <= nums.length; i++) {
            missingInts.add(i);
        }
        return missingInts;
    }
}
