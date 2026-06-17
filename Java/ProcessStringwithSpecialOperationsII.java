public class ProcessStringwithSpecialOperationsII {
    
    public char processStr(String s, long k) {
        int n = s.length();
        // lengths[i] = length of the result after processing s[0..i]
        long[] lengths = new long[n];
        long len = 0;

         // Forward pass: compute only lengths
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if (Character.isLowerCase(c)){
                len++;
            }
            else if (c == '*'){
                if (len > 0){
                    len--;
                }
            }

            else if (c == '#'){
                len += len;
            }

             // '%' does not change length
            
            lengths[i] = len;

        }

        // Index out of bounds
        if (k >= len ){
            return '.';
        }

        // Backward pass: trace where index k came from
        for (int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            long currentLen = lengths[i];
            long prevLen = (i == 0) ? 0 : lengths[i-1];

            if (Character.isLowerCase(c)){
                // This letter was appended at the end
                if (k == currentLen - 1){
                    return c;
                }
            }
            else if (c == '#'){
                // result was previous + previous
                if (k >= prevLen){
                    k -= prevLen;
                }
            }
            else if (c == '%'){
                // reverse maps index k to len - 1 - k
                k = currentLen - k - 1;
            }

             // '*' just reduced length in forward direction; k unchanged
        }

        return '.';
    }

    public static void main(String[] args) {
        ProcessStringwithSpecialOperationsII solution = new ProcessStringwithSpecialOperationsII();
        String s = "a#b%*";
        long k = 1;
        char result = solution.processStr(s, k);
        System.out.println(result); // Output: "a"

        ProcessStringwithSpecialOperationsII solution2 = new ProcessStringwithSpecialOperationsII();
        String s2 = "cd%#*#";
        long k2 = 3;
        char result2 = solution2.processStr(s2, k2);
        System.out.println(result2); // Output: "d"

        ProcessStringwithSpecialOperationsII solution3 = new ProcessStringwithSpecialOperationsII();
        String s3 = "z*#";
        long k3 = 0;
        char result3 = solution3.processStr(s3, k3);
        System.out.println(result3); // Output: "."

        ProcessStringwithSpecialOperationsII solution4 = new ProcessStringwithSpecialOperationsII();
        String s4 = "%#bz%xum##i##vzo#pwc*#dkwbh####%uf%s*%cgppqhqa%h#l##o%ij%%cz%iga##e###u%#e####jfwx##%%*x%m*%#";
        long k4 = 6523;
        char result4 = solution4.processStr(s4, k4);
        System.out.println(result4); // Output: "z"
    }
    
}
