

public class ValidParenthesisString {
    
    public boolean checkValidString(String s) {
        // Minimum possible '('
        int low = 0;
        // Maximum Possible ')'
        int high = 0;

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                low++;
                high++;
            }

            if (s.charAt(i) == ')'){
                low--;
                high--;
            }

            if(s.charAt(i) == '*'){

                // treat '*' as ')'
                low--;
                // treat '*' as '('
                high++;
            }

              // Too many ')' no matter how we use '*'
            if (high < 0) return false;

             // Minimum unmatched '(' cannot be negative
            low = Math.max(low, 0);
        }
        
        
        return low == 0;
    }

    public static void main(String[] args) {
        ValidParenthesisString solution = new ValidParenthesisString();
        String s = "()";
        boolean result = solution.checkValidString(s);
        System.out.println("Is valid parenthesis string: " + result);

        ValidParenthesisString solution2 = new ValidParenthesisString();
        String s2 = "(*)";
        boolean result2 = solution2.checkValidString(s2);
        System.out.println("Is valid parenthesis string: " + result2);

        ValidParenthesisString solution3 = new ValidParenthesisString();
        String s3 = "(*))";
        boolean result3 = solution3.checkValidString(s3);
        System.out.println("Is valid parenthesis string: " + result3);
    }
    
}
