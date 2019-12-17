public class MinAddToMakeParanthesesValid {

    public int minAddToMakeValid(String S) {
        int ret = 0;
        int counter = 0;
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (cur == '(') {
                counter++;
            } else {
                if (counter == 0) {
                    ret++;
                } else {
                    counter--;
                }
            }
        }
        return ret + counter;
    }
}
