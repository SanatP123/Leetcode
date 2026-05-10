import java.util.HashMap;
import java.util.regex.*;
public class CountValidWordOccurrences {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        int n = queries.length;
        int[] ans = new int[n];

        String concat = "";

        for (String chunk : chunks){
            concat += chunk;
        }

        // Valid word pattern
        Pattern pattern = Pattern.compile("[a-z]+(?:-[a-z]+)*");

        Matcher matcher = pattern.matcher(concat);

        HashMap<String, Integer> map = new HashMap<>();

        // Extract all valid words
        while (matcher.find()) {

            String word = matcher.group();

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

         for (int i = 0; i < n; i++) {
            ans[i] = map.getOrDefault(queries[i], 0);
        }

        return ans;

        
    }
    public static void main(String[] args) {
        CountValidWordOccurrences sol = new CountValidWordOccurrences();
        String[] chunks = {"hello wor","ld hello"};
        String[] queries = {"hello","world","wor"};
        int[] ans = sol.countWordOccurrences(chunks, queries);
        for (int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }

        CountValidWordOccurrences sol2 = new CountValidWordOccurrences();
        String[] chunks2 = {"a--b a-","-c"};
        String[] queries2 = {"a","b","c"};
        int[] ans2 = sol2.countWordOccurrences(chunks2, queries2);
        System.out.println();
        for (int i = 0; i < ans2.length; i++){
            System.out.print(ans2[i] + " ");    
        }

        CountValidWordOccurrences sol3 = new CountValidWordOccurrences();
        String[] chunks3 = {"hello"};     
        String[] queries3 = {"hello","ell"};
        int[] ans3 = sol3.countWordOccurrences(chunks3, queries3);
        System.out.println();
        for (int i = 0; i < ans3.length; i++){
            System.out.print(ans3[i] + " ");
        }
    }
    
}
