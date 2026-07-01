public class ReverseOnlyLetters {
    
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        int left = 0;
        int right = n-1;

        char[] ch = s.toCharArray();

        while (left < right){
            

            if(!isAlphabet(ch[left])){
                left++;
            }
            else if (!isAlphabet(ch[right])){
                right--;
            }
            else {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
            
            
        }

        return new String(ch);
        
    }

    private boolean isAlphabet(char c){
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ReverseOnlyLetters solution = new ReverseOnlyLetters();
        String s = "ab-cd";
        String result = solution.reverseOnlyLetters(s);
        System.out.println("Reversed string: " + result);

        String s2 = "a-bC-dEf-ghIj";
        String result2 = solution.reverseOnlyLetters(s2);
        System.out.println("Reversed string: " + result2);

        String s3 = "Test1ng-Leet=code-Q!";
        String result3 = solution.reverseOnlyLetters(s3);
        System.out.println("Reversed string: " + result3);
    }
    
}
