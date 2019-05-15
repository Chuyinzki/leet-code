import java.util.HashMap;
import java.util.List;

public class MaxCoins {

    HashMap<List<Integer>, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8})); //Should be 167
    }

    public static int maxCoins(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int popeye = (i == 0 ? 1 : nums[i - 1]) * nums[i] * (i == nums.length - 1 ? 1 : nums[i + 1]);
            int[] newArr = new int[nums.length - 1];
            System.arraycopy(nums, 0, newArr, 0, i);
            System.arraycopy(nums, i + 1, newArr, i, newArr.length - i);
            max = Math.max(max, popeye + maxCoins(newArr));
        }
        return max;
    }
}
