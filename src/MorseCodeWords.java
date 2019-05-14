import java.util.HashMap;
import java.util.HashSet;

public class MorseCodeWords {
    static final String[] morseMappings = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    final static HashMap mappy = new HashMap();

    static {
        for (int i = 0; i < morseMappings.length; i++)
            mappy.put((char) ('a' + i), morseMappings[i]);
    }

    public static void main(String[] args) {
        uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}); //should output 2
    }

    public static int uniqueMorseRepresentations(String[] words) {
        final HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder morseRep = new StringBuilder();
            for (int i = 0; i < word.length(); i++)
                morseRep.append(mappy.get(word.charAt(i)));
            set.add(morseRep.toString());
        }
        return set.size();
    }
}
