
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // Pattern finished -> text must also be finished
        if (p.isEmpty()) return s.isEmpty();

         // Check if first characters match
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        // Handle '*' case
        if (p.length() >= 2 && p.charAt(1) == '*'){
            // Option 1: skip "x*" or  Option 2: use '*' once and stay on same pattern
            return (isMatch(s,p.substring(2)) || (first_match && isMatch(s.substring(1),p)));
        }
        // Normal character match -> move both forward
        else{
            return (first_match && isMatch(s.substring(1), p.substring(1)));
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching sol = new RegularExpressionMatching();
        String s = "aa";
        String p = "a";
        boolean ans = sol.isMatch(s, p);
        System.out.println(ans);

        RegularExpressionMatching sol2 = new RegularExpressionMatching();
        String s2 = "aa";
        String p2 = "a*";
        boolean ans2 = sol2.isMatch(s2, p2);
        System.out.println(ans2);

        RegularExpressionMatching sol3 = new RegularExpressionMatching();
        String s3 = "ab";
        String p3 = ".*";
        boolean ans3 = sol3.isMatch(s3, p3);
        System.out.println(ans3);
    }
}