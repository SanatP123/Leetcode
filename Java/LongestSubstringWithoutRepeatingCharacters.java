import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
          // Stores characters currently in the sliding window
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        int left = 0;

         // Expand the window using right pointer
        for (int right = 0; right < s.length(); right++){
            char c = s.charAt(right);

            // If duplicate exists, shrink window from the left until we remove the duplicate character
            while (set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }

             // Add current character to the window
            set.add(c);
            ans = Math.max(ans,right - left + 1);
        }

        return ans;
        
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

        // Test case 1
        String s1 = "abcabcbb";
        System.out.println("Test 1: " + solution.lengthOfLongestSubstring(s1));  // Expected: 3

        // Test case 2
        String s2 = "bbbbb";
        System.out.println("Test 2: " + solution.lengthOfLongestSubstring(s2));  // Expected: 1

        // Test case 3
        String s3 = "pwwkew";
        System.out.println("Test 3: " + solution.lengthOfLongestSubstring(s3));  // Expected: 3
    }
    
}
