package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-email-addresses
 */
public class Unique_Email_Addresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> unique_emails = new HashSet<>();

        for (String email : emails) {
            int split_position = email.indexOf("@");
            String local_name = email.substring(0, split_position);
            String domain_name = email.substring(split_position);

            if (local_name.contains("+")) {
                int plus_position = local_name.indexOf("+");
                local_name = local_name.substring(0, plus_position);
            }
            local_name = local_name.replaceAll("\\.", "");
            String new_name = local_name + domain_name;
            unique_emails.add(new_name);
        }

        return unique_emails.size();
    }
}
