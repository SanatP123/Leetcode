public class CounttheNumberofSpecialCharactersI {
    
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        int count = 0;

        // Record which lowercase / uppercase letters exist
        for (char c : word.toCharArray()){
            if (Character.isLowerCase(c)){
                lower[c - 'a'] = true;
            }
            else{
                upper[c - 'A'] = true;
            }
        }

         // Count letters appearing in both cases
        for (int i = 0; i < 26; i++){
            if (lower[i] && upper[i]){
                count++;
            }
        }

        return count;
        
    }

    public static void main(String[] args) {
        CounttheNumberofSpecialCharactersI solution = new CounttheNumberofSpecialCharactersI();
        String word = "aAbBcC";
        int result = solution.numberOfSpecialChars(word);
        System.out.println("Number of special characters: " + result);

        CounttheNumberofSpecialCharactersI solution2 = new CounttheNumberofSpecialCharactersI();
        String word2 = "abc";
        int result2 = solution2.numberOfSpecialChars(word2);
        System.out.println("Number of special characters: " + result2);

        CounttheNumberofSpecialCharactersI solution3 = new CounttheNumberofSpecialCharactersI();
        String word3 = "AaAaAa";
        int result3 = solution3.numberOfSpecialChars(word3);
        System.out.println("Number of special characters: " + result3);
    }
}
