import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2)); // answer should be 56
    }

    public static int uniquePaths(int m, int n) {
        if (n == 0 || m == 0) return 0;
        return (int) uniquePathsHelper(m, n, new HashMap<>())[0];
    }

    public static Object[] uniquePathsHelper(int m, int n, HashMap<List<Integer>, Integer> map) {
        if (n == 0 || m == 0) {
            map.put(Arrays.asList(m, n), 0);
            return new Object[]{0, map};
        }
        if ((m == 1 && n == 2) || (m == 2 && n == 1) || (m == 1 && n == 1)) {
            map.put(Arrays.asList(m, n), 1);
            return new Object[]{1, map};
        }
        Integer curDimension = m * n;
        Integer curAnswer = map.get(curDimension);
        if (curAnswer != null)
            return new Object[]{curAnswer, map};
        Object[] ans1 = uniquePathsHelper(m - 1, n, map);
        Object[] ans2 = uniquePathsHelper(m, n - 1, (HashMap<List<Integer>, Integer>) ans1[1]);
        map = (HashMap<List<Integer>, Integer>) ans2[1];
        map.put(Arrays.asList(m, n), (int) ans1[0] + (int) ans2[0]);
        return new Object[]{(int) ans1[0] + (int) ans2[0], ans2[1]};
    }
}
