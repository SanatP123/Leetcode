public class ProcessStringwithSpecialOperationsI {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()){
            if (Character.isLowerCase(c)){
                result.append(c);
            }
            else if (c == '*'){
                if (result.length() > 0){
                    result.deleteCharAt(result.length() - 1);
                }
            }
            else if (c == '#'){
                result.append(result);
            }
            else{
                result.reverse();
            }
        }

        return result.toString();
        
    }

    public static void main(String[] args) {
        ProcessStringwithSpecialOperationsI solution = new ProcessStringwithSpecialOperationsI();
        String s = "a#b%*";
        String result = solution.processStr(s);
        System.out.println(result); // Output: "ba"

        ProcessStringwithSpecialOperationsI solution2 = new ProcessStringwithSpecialOperationsI();
        String s2 = "z*#";
        String result2 = solution2.processStr(s2);
        System.out.println(result2); // Output: ""

        ProcessStringwithSpecialOperationsI solution3 = new ProcessStringwithSpecialOperationsI();
        String s3 = "abc#d*e%";
        String result3 = solution3.processStr(s3);
        System.out.println(result3); // Output: "ecbacba"
    }
    
}
