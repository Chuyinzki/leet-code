import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MaxCoins {

    static HashMap<List<Integer>, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2, 5, 5}));
    }

    public static int maxCoins(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int popeye = (i == 0 ? 1 : nums[i - 1]) * nums[i] * (i == nums.length - 1 ? 1 : nums[i + 1]);
            int[] newArr = new int[nums.length - 1];
            System.arraycopy(nums, 0, newArr, 0, i);
            System.arraycopy(nums, i + 1, newArr, i, newArr.length - i);
            Integer cachedValue = cache.get(Arrays.stream(newArr).boxed().collect(Collectors.toList()));
            max = Math.max(max, popeye + (cachedValue != null ? cachedValue : maxCoins(newArr)));
        }
        cache.put(Arrays.stream(nums).boxed().collect(Collectors.toList()), max);
        return max;
    }
}
