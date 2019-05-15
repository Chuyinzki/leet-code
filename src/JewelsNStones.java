public class JewelsNStones {
    public int numJewelsInStones(String J, String S) {
        int ret = 0;
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            for (int j = 0; j < S.length(); j++) {
                ret += c == S.charAt(j) ? 1 : 0;
            }
        }
        return ret;
    }
}
