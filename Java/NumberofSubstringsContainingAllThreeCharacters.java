public class NumberofSubstringsContainingAllThreeCharacters {
    
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0;
        int res = 0;

        // Frequency of a, b, c in current window
        int[] freq = new int[3];

        for (int right = 0; right < n; right++){
            char curr = s.charAt(right);
            freq[curr - 'a']++;

            // Shrink while window contains all three characters
            while (isFull(freq)){

                // All substrings ending at right..n-1 are valid
                res += n - right;
                char prev = s.charAt(left);
                freq[prev - 'a']--;
                left++;
            }

        }

        return res;
        
    }

    // Check if current window contains a, b, and c
    private boolean isFull(int[] freq){
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }

    public static void main(String[] args) {
        NumberofSubstringsContainingAllThreeCharacters solution = new NumberofSubstringsContainingAllThreeCharacters();
        String s = "abcabc";
        int result = solution.numberOfSubstrings(s);
        System.out.println("Number of substrings containing all three characters: " + result);

        String s2 = "aaacb";
        int result2 = solution.numberOfSubstrings(s2);
        System.out.println("Number of substrings containing all three characters: " + result2);

        String s3 = "abc";
        int result3 = solution.numberOfSubstrings(s3);
        System.out.println("Number of substrings containing all three characters: " + result3);
    }
    
}
