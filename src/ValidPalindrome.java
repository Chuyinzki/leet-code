public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.print(isPalindrome("A man, a plan, a canal: Panama")); //Should return true
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            //move up
            while (start < s.length() && !Character.isAlphabetic(s.charAt(start))) start++;
            while (end >= 0 && !Character.isAlphabetic(s.charAt(end))) end--;
            if (start > end) return false;
            int diff = Math.abs(s.charAt(end) - s.charAt(start));
            if (diff != 0 && diff != 32) return false;
            start++;
            end--;
        }
        return true;
    }
}
