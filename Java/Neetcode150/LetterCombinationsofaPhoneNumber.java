import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        

        List<String> res = new ArrayList<>();

        if (digits.length() == 0){
            return res;
        }

        backtrack(0, res, phoneMap, digits, new StringBuilder());

        return res;
        
    }

    private void backtrack(int index, List<String> res, HashMap<Character, String> phoneMap, String digits, StringBuilder current){
        if (index == digits.length()){
            res.add(current.toString());
            return;
        }

        String letters = phoneMap.get(digits.charAt(index));
        for (char c : letters.toCharArray()){    
            current.append(c);
            backtrack(index + 1, res, phoneMap, digits, current);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String args[]){
        LetterCombinationsofaPhoneNumber sol = new LetterCombinationsofaPhoneNumber();
        String digits = "23";
        List<String> ans = sol.letterCombinations(digits);
        for (String s : ans){
            System.out.print(s + " ");
        }
        System.out.println();

        LetterCombinationsofaPhoneNumber sol2 = new LetterCombinationsofaPhoneNumber();
        String digits2 = "";
        List<String> ans2 = sol2.letterCombinations(digits2);
        for (String s : ans2){
            System.out.print(s + " ");
        }
        System.out.println();

        LetterCombinationsofaPhoneNumber sol3 = new LetterCombinationsofaPhoneNumber();
        String digits3 = "2";
        List<String> ans3 = sol3.letterCombinations(digits3);
        for (String s : ans3){
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
}
