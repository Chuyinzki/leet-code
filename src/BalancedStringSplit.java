public class BalancedStringSplit {

    public int balancedStringSplit(String s) {
        int ret = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == 'L') {
                count++;
            } else if (curChar == 'R') {
                count--;
            }
            if (count == 0) {
                ret++;
            }
        }
        return ret;
    }
}
