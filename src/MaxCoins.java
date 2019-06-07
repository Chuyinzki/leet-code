import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MaxCoins {

    static HashMap<List<Integer>, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(
            maxCoins(new int[]{8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2, 5, 5}));
    }

    public static int maxCoins(int[] nums) {
        return maxCoinsHelper(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    public static int maxCoinsHelper(List<Integer> nums) {
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            int popeye = (i == 0 ? 1 : nums.get(i - 1)) * nums.get(i) * (i == nums.size() - 1 ? 1
                : nums.get(i + 1));
            List<Integer> newArr = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                newArr.add(nums.get(j));
            }
            for (int j = i + 1; j < nums.size(); j++) {
                newArr.add(nums.get(j));
            }
            Integer cachedValue = cache.get(newArr);
            max = Math
                .max(max, popeye + (cachedValue != null ? cachedValue : maxCoinsHelper(newArr)));
        }
        cache.put(nums, max);
        return max;
    }
}
