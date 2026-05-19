

import java.util.HashSet;
import java.util.Stack;

/**
     * Uses a sliding window + HashSet approach.
     *
     * Maintain a window [left, right] containing unique characters.
     * Expand the window by moving right.
     * If a duplicate appears, shrink the window from the left
     * until the duplicate is removed.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(min(n, charset))
     */

public class LongestSubstringWithoutRepeatedCharacters {
     public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int left = 0;
        int right = 0;
        int ans = 0;

        // Stores chars currently in the window
        HashSet<Character> seen = new HashSet<>();

        while (right < n) {

            // Shrink window until duplicate is removed
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }

            // Expand window
            seen.add(s.charAt(right));

            // Update longest valid substring length
            ans = Math.max(ans, right - left + 1);

            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatedCharacters sol = new LongestSubstringWithoutRepeatedCharacters();
        String s = "abcabcbb";
        int ans = sol.lengthOfLongestSubstring(s);
        System.out.println(ans);

        LongestSubstringWithoutRepeatedCharacters sol2 = new LongestSubstringWithoutRepeatedCharacters();
        String s2 = "bbbbb";
        int ans2 = sol2.lengthOfLongestSubstring(s2);
        System.out.println(ans2);

        LongestSubstringWithoutRepeatedCharacters sol3 = new LongestSubstringWithoutRepeatedCharacters();
        String s3 = "pwwkew";
        int ans3 = sol3.lengthOfLongestSubstring(s3);
        System.out.println(ans3);
    }
    
}
