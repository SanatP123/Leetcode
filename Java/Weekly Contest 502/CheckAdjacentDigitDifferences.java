public class CheckAdjacentDigitDifferences {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        int length = s.length();
        
        for (int i = 0; i < length-1; i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            int digit = a - '0';
            int next = b - '0';
            if (Math.abs(next - digit) > 2){
                return false;
            }
        }

        return true;
        
    }

    public static void main(String[] args) {
        CheckAdjacentDigitDifferences sol = new CheckAdjacentDigitDifferences();
        String s = "132";
        boolean ans = sol.isAdjacentDiffAtMostTwo(s);
        System.out.println(ans);

        CheckAdjacentDigitDifferences sol2 = new CheckAdjacentDigitDifferences();
        String s2 = "129";
        boolean ans2 = sol2.isAdjacentDiffAtMostTwo(s2);
        System.out.println(ans2);
    }
    
}
