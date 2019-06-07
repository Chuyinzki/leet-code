import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindAnagrams {

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }
        List<Integer> ret = new ArrayList<>();
        char pArray[] = p.toCharArray();
        Arrays.sort(pArray);
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            char[] tempArray = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(tempArray);
            if (Arrays.equals(pArray, tempArray)) {
                ret.add(i);
            }
        }
        return ret;
    }
}
