public class ValidDigitNumber {
    public boolean validDigit(int n, int x) {
        String s = Integer.toString(n);
        char d = (char)(x + '0');
        if (s.charAt(0) == d){
            return false;
        }
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == d){
                return true;
        }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidDigitNumber sol = new ValidDigitNumber();
        int n = 101;
        int x = 0;
        boolean ans = sol.validDigit(n, x);
        System.out.println(ans);

        ValidDigitNumber sol2 = new ValidDigitNumber();
        int n2 = 232;
        int x2 = 2;
        boolean ans2 = sol2.validDigit(n2, x2);
        System.out.println(ans2);

        ValidDigitNumber sol3 = new ValidDigitNumber();
        int n3 = 5;
        int x3 = 1;
        boolean ans3 = sol3.validDigit(n3, x3);
        System.out.println(ans3);
    }
    
}
