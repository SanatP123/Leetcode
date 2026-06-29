public class NumberofStringsThatAppearasSubstringsinWord {
    public int numOfStrings(String[] patterns, String word) {

        int count = 0;
        for (String p : patterns){
            if (word.contains(p)){
                count++;
            }
        }

        return count;
        
    }

    public static void main(String[] args) {
        NumberofStringsThatAppearasSubstringsinWord solution = new NumberofStringsThatAppearasSubstringsinWord();
        String[] patterns = {"a", "abc", "bc", "d"};
        String word = "abc";
        int result = solution.numOfStrings(patterns, word);
        System.out.println("Number of strings that appear as substrings: " + result);

        String[] patterns2 = {"a", "b", "c"};
        String word2 = "aaaaabbbbb";
        int result2 = solution.numOfStrings(patterns2, word2);
        System.out.println("Number of strings that appear as substrings: " + result2);

        String[] patterns3 = {"a", "a", "a"};
        String word3 = "ab";
        int result3 = solution.numOfStrings(patterns3, word3);
        System.out.println("Number of strings that appear as substrings: " + result3);
    }


    
}
