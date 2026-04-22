import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsofDictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        

        ArrayList<String> ans = new ArrayList<String>();

        for (String query: queries){
            for (String dict: dictionary){
                if (check_edits(query,dict)){
                    ans.add(query);
                    break;  // avoid duplicates
                }

            }
        }
        
        return ans;        
    }

    // returns true if words differ in at most 2 positions
    public Boolean check_edits(String word1, String word2){
            int count = 0;
            for (int i = 0; i < word1.length(); i++){
                if (word1.charAt(i) != word2.charAt(i)){
                    count += 1;
                    if (count > 2){
                        return false; //early exit
                    }
                }
            }

            return count <= 2;
        }

    
    public static void main(String[] args) {
        WordsWithinTwoEditsofDictionary sol = new WordsWithinTwoEditsofDictionary();
        String[] queries = {"word","note","ants","wood"};
        String[] dictionary = {"wood","joke","moat"};
        System.out.println(sol.twoEditWords(queries, dictionary));

        WordsWithinTwoEditsofDictionary sol2 = new WordsWithinTwoEditsofDictionary();
        String[] queries2 = {"yes"};
        String[] dictionary2 = {"not"};
        System.out.println(sol2.twoEditWords(queries2, dictionary2));
    }    
    
}
