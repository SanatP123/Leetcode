import java.util.Arrays;

public class CounttheNumberofSpecialCharactersII {
    public int numberOfSpecialChars(String word) {

        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];


        Arrays.fill(lastLower, -1);
        Arrays.fill(firstUpper, -1);

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            // If character is lowercase update everytime
            if (Character.isLowerCase(c)){
                lastLower[c - 'a'] = i;
            }
            // If character is uppercase only keep the first occurence
            else{
                if(firstUpper[c - 'A'] == -1){
                    firstUpper[c - 'A'] = i;
                }
            }

        }

        int special = 0;

        for (int i = 0; i < 26; i++){
            // Every lowercase must appear before first uppercase
            if (lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]){
                special++;
            }
        }

        return special;
        
    }

    public static void main(String[] args) {
        CounttheNumberofSpecialCharactersII solution = new CounttheNumberofSpecialCharactersII();
        String word = "aAbBcC";
        int result = solution.numberOfSpecialChars(word);
        System.out.println("Number of special characters: " + result);

        CounttheNumberofSpecialCharactersII solution2 = new CounttheNumberofSpecialCharactersII();
        String word2 = "abc";
        int result2 = solution2.numberOfSpecialChars(word2);
        System.out.println("Number of special characters: " + result2);

        CounttheNumberofSpecialCharactersII solution3 = new CounttheNumberofSpecialCharactersII();
        String word3 = "AaAaAa";
        int result3 = solution3.numberOfSpecialChars(word3);
        System.out.println("Number of special characters: " + result3);
    }
    
}
