import java.util.Arrays;

public class PermutationinString {
    
    public boolean checkInclusion(String s1, String s2) {

        // If s1 is longer, no permutation can exist in s2
        if (s1.length() > s2.length()) return false;


        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Build frequency arrays for s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            char d = s2.charAt(i);
            freq1[c - 'a']++;
            freq2[d - 'a']++;
        }

        // Check the first window
        if (Arrays.equals(freq1,freq2)) return true;

        for (int right = s1.length(); right < s2.length(); right++){

            // Add the new character entering the window
            freq2[s2.charAt(right) - 'a']++;

             // Remove the character leaving the window
            freq2[s2.charAt(right - s1.length()) - 'a']--;

            if (Arrays.equals(freq1,freq2)) return true;

        }

        return false;

        
    }

    public static void main(String[] args) {
        PermutationinString solution = new PermutationinString();
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = solution.checkInclusion(s1, s2);
        System.out.println(result); // Output: true

        PermutationinString solution2 = new PermutationinString();
        String s3 = "ab";
        String s4 = "eidboaoo";
        boolean result2 = solution2.checkInclusion(s3, s4);
        System.out.println(result2); // Output: false
    }
    
}
