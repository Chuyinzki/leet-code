public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.print(isPalindrome("0P")); //Should return true
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            //move up
            while (start < s.length() && !Character.isAlphabetic(s.charAt(start)) && !Character
                .isDigit(s.charAt(start))) {
                start++;
            }
            while (end >= 0 && !Character.isAlphabetic(s.charAt(end)) && !Character
                .isDigit(s.charAt(end))) {
                end--;
            }
            if (start > end) {
                return true;
            }

            char sChar = s.charAt(start);
            char eChar = s.charAt(end);
            int diff = Math.abs(eChar - sChar);
            if (sChar <= 122 && sChar >= 65 && eChar <= 122 && eChar >= 54) {
                if (diff != 0 && diff != 32) {
                    return false;
                }
            } else if (diff != 0) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
