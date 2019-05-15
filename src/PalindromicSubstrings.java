public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa")); //should return 6
    }

    public static int countSubstrings(String s) {
        if (s.length() == 1) return 1;
        int palindromes = 0;
        for (int i = 0; i < s.length(); i++) { //aaa
            palindromes += isPalindrome(s.substring(0, i + 1)) ? 1 : 0;
        }
        return palindromes + countSubstrings(s.substring(1));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }
}
