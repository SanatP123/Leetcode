public class PalindromicSubstrings {
    
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        
        for (int i = 0; i < n; i++){
            // odd-length palindromes, single character center
            ans += countpalindromes(s,i,i);
            // even-length palindromes, consecutive characters center
            ans += countpalindromes(s,i,i+1);
        }

        return ans;
        
    }

    public int countpalindromes(String s, int left, int right){
        int ans = 0;
        while (left >= 0 && right < s.length()){
            if (s.charAt(left) != s.charAt(right)){
                // the first and last characters don't match!
                break;
            }
            // expand around the center
            left--;
            right++;

            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        PalindromicSubstrings sol = new PalindromicSubstrings();
        String s = "abc";
        int ans = sol.countSubstrings(s);
        System.out.println(ans);

        PalindromicSubstrings sol2 = new PalindromicSubstrings();
        String s2 = "aaa";
        int ans2 = sol2.countSubstrings(s2);
        System.out.println(ans2);
    }

    
}
