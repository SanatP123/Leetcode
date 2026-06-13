public class WeightedWordMapping {
    
    public String mapWordWeights(String[] words, int[] weights) {
        
        StringBuilder res = new StringBuilder();

        for (String s : words){
            // Track the sum of characters in a word
            int current_sum = 0;

            for(int i=0; i<s.length(); i++){
                current_sum += weights[s.charAt(i) - 'a'];
            }

            

            // Map the result using reverse alphabetical order
            res.append((char) ('z' - (current_sum % 26)));
        
        }

    return res.toString();
    }


    public static void main(String[] args) {
        WeightedWordMapping solution = new WeightedWordMapping();
        String[] words = {"abcd","def","xyz"};
        int[] weights = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        String result = solution.mapWordWeights(words, weights);
        System.out.println(result); 

        WeightedWordMapping solution2 = new WeightedWordMapping();
        String[] words2 = {"a","b","c"};
        int[] weights2 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        String result2 = solution2.mapWordWeights(words2, weights2);
        System.out.println(result2); 

        WeightedWordMapping solution3 = new WeightedWordMapping();
        String[] words3 = {"abcd"};
        int[] weights3 = {7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5};
        String result3 = solution3.mapWordWeights(words3, weights3);
        System.out.println(result3);    
    }
}
