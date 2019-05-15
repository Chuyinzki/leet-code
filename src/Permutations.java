import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return Collections.singletonList(Collections.emptyList());
        Arrays.sort(nums);
        return (List<List<Integer>>) permuteHelper(Arrays.stream(nums).boxed().collect(Collectors.toList()), new HashMap<>())[0];
    }

    public static Object[] permuteHelper(
            List<Integer> orderedList, HashMap<List<Integer>, List<List<Integer>>> solvedPermutations) {
        if (orderedList.size() == 1)
            return new Object[]{Collections.singletonList(orderedList), solvedPermutations};
        if (orderedList.size() == 2) {
            List<List<Integer>> retList = new ArrayList<>();
            retList.add(Arrays.asList(orderedList.get(0), orderedList.get(1)));
            retList.add(Arrays.asList(orderedList.get(1), orderedList.get(0)));
            return new Object[]{retList, solvedPermutations};
        }
        List<List<Integer>> retList = new ArrayList<>();
        for (int i = 0; i < orderedList.size(); i++) {
            List<Integer> subList = new ArrayList<>();
            if (i != 0)
                subList.addAll(orderedList.subList(0, i));
            if (i != orderedList.size() - 1)
                subList.addAll(orderedList.subList(i + 1, orderedList.size()));
            List<List<Integer>> permutedSublist = solvedPermutations.get(subList);
            if (permutedSublist == null) {
                Object[] result = permuteHelper(subList, solvedPermutations);
                permutedSublist = (List<List<Integer>>) result[0];
                solvedPermutations = (HashMap<List<Integer>, List<List<Integer>>>) result[1];
                solvedPermutations.put(subList, permutedSublist);
            }
            for (List<Integer> sublisty : permutedSublist) {
                List<Integer> addList = new ArrayList<>(sublisty);
                addList.add(0, orderedList.get(i));
                retList.add(addList);
            }
        }
        return new Object[]{retList, solvedPermutations};
    }
}
