import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        return wordBreakHelper(s, dict);
    }

    private static boolean wordBreakHelper(String s, Set<String> dict) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i + 1))) {
                if (i + 1 == s.length()) return true;
                else {
                    boolean attempt = wordBreakHelper(s.substring(i + 1), dict);
                    if (attempt) return true;
                }
            }
        }
        return false;
    }
}
