public class SubsequenceAfterOneReplacement {
    public boolean canMakeSubsequence(String s, String t) {
        int i = 0, j = 0, n = s.length(), m = t.length();

        // i -> matched characters after using one replacement
        // j -> matched characters without replacement
        if (n>m) return false;

        for (char c : t.toCharArray()){
            // Extend the "replacement used" state by normal matching
            if (s.charAt(i) == c){
                i++;
            }

            // Use the one replacement at the current unmatched position
            i = Math.max(i, j+1);

            // Extend the normal subsequence match
            if(s.charAt(j) == c){
                j++;
            }

            // Entire string matched
            if (i == n || j == n){
                return true;
            }
        }
        return false;
        
    }

    public static void main(String[] args) {
        SubsequenceAfterOneReplacement solution = new SubsequenceAfterOneReplacement();
        String s1 = "cat";
        String t1 = "chat";
        System.out.println("Can make subsequence: " + solution.canMakeSubsequence(s1, t1)); // Output: true

        String s2 = "plane";
        String t2 = "apple";
        System.out.println("Can make subsequence: " + solution.canMakeSubsequence(s2, t2)); // Output: false

        String s3 = "wx";
        String t3 = "xwxt";
        System.out.println("Can make subsequence: " + solution.canMakeSubsequence(s3, t3)); // Output: true
    }

    
}
