import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> current = new Stack<>();
        HashMap<Character,Character> valid = new HashMap<>();
        valid.put(')','(');
        valid.put('}','{');
        valid.put(']','[');

        for (Character c: s.toCharArray()){
            if (c == ')' || c == '}' || c == ']'){
                if (current.isEmpty()){
                    return false;
                }
                else {
                    Character top = current.peek();
                    current.pop();
                    if (top != valid.get(c)){
                        return false;
                    }
                }
            }

            else {
                current.add(c);
            }
        }

        return current.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses sol = new ValidParentheses();
        String s = "()";
        boolean ans = sol.isValid(s);
        System.out.println(ans);

        ValidParentheses sol2 = new ValidParentheses();
        String s2 = "()[]{}";
        boolean ans2 = sol2.isValid(s2);
        System.out.println(ans2);

        ValidParentheses sol3 = new ValidParentheses();
        String s3 = "(]";
        boolean ans3 = sol3.isValid(s3);
        System.out.println(ans3);
    }
}
    
