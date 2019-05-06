import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {
    public static void main(String[] args) {
        //Should return 2
        numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"});
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            String cleanEmail = email.substring(0, email.indexOf('@')).replaceAll("\\.", "") + email.substring(email.indexOf('@'));
            if (cleanEmail.contains("+")) {
                cleanEmail = cleanEmail.substring(0, cleanEmail.indexOf('+')) + cleanEmail.substring(cleanEmail.indexOf('@'));
            }
            emailSet.add(cleanEmail);
        }
        return emailSet.size();
    }
}
