public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
         // Stores start and end indices of best palindrome found
        int[] ans = new int[]{0,0};

        for (int i = 0; i < s.length(); i++){
            // Try odd-length palindrome centered at i
            int odd = expand(i,i,s);

            
            if (odd > ans[1] - ans[0] + 1){
                // Radius from center to boundary
                int dist = odd/2;
                // Recover start/end indices
                ans[0] = i - dist;
                ans[1] = i + dist;
            }

             // Try even-length palindrome centered between i and i+1
            int even = expand(i,i+1,s);
            if (even > ans[1] - ans[0] + 1){
                // Adjust radius for even-length case
                int dist = (even / 2) - 1;
                ans[0] = i - dist;
                ans[1] = i + 1 + dist;
            }
        }

        int i = ans[0];
        int j = ans[1];
        // Return longest palindrome substring
        return s.substring(i,j+1);

        
    }

    public int expand(int i, int j, String s){
        int left = i;
        int right = j;

        // Expand outward while palindrome condition holds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        } 
        // We overshoot by one step, so subtract 1 on both sides
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
        String s = "babad";
        String ans = sol.longestPalindrome(s);
        System.out.println(ans);

        LongestPalindromicSubstring sol2 = new LongestPalindromicSubstring();
        String s2 = "cbbd";
        String ans2 = sol2.longestPalindrome(s2);
        System.out.println(ans2);

        LongestPalindromicSubstring sol3 = new LongestPalindromicSubstring();
        String s3 = "a";
        String ans3 = sol3.longestPalindrome(s3);
        System.out.println(ans3);
    }
    
}
