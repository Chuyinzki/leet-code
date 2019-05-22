public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.print(isPalindrome("0P")); //Should return true
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            //move up
            while (start < s.length() && !Character.isAlphabetic(s.charAt(start)) && !Character.isDigit(s.charAt(start))) start++;
            while (end >= 0 && !Character.isAlphabetic(s.charAt(end)) && !Character.isDigit(s.charAt(end))) end--;
            if (start > end) return true;
            int diff = Math.abs(s.charAt(end) - s.charAt(start));
            if (start <= 122 && start >= 65 && end <= 122 && end >= 54) {
                if(diff != 0 && diff != 32) return false;
            } else if(diff != 0) return false;
            start++;
            end--;
        }
        return true;
    }
}
