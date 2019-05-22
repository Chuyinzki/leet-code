public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.print(isPalindrome("A man, a plan, a canal: Panama")); //Should return true
    }

    public static boolean isPalindrome(String toCheck) {
        int start = 0;
        int end = toCheck.length() - 1;
        while (start < end) {
            //move up
            while (start < toCheck.length() && !Character.isAlphabetic(toCheck.charAt(start))) start++;
            while (end >= 0 && !Character.isAlphabetic(toCheck.charAt(end))) end--;
            if (start > end) return false;
            int diff = Math.abs(toCheck.charAt(end) - toCheck.charAt(start));
            if (diff != 0 && diff != 32) return false;
            start++;
            end--;
        }
        return true;
    }
}
