public class ExactlyOneConsecutiveSetBitsPair {
    
    public boolean consecutiveSetBits(int n) {
        String binary = Integer.toBinaryString(n);
        int count = 0;

        for (int i = 1; i < binary.length(); i++){
            if (binary.charAt(i) == '1' && binary.charAt(i-1) == '1'){
                count++;
            }
            if (count > 1){
                return false;
            }
            
            
        }

        return count == 1;
        
    }

    public static void main(String[] args) {
        ExactlyOneConsecutiveSetBitsPair solution = new ExactlyOneConsecutiveSetBitsPair();
        int n = 5;
        boolean result = solution.consecutiveSetBits(n);
        System.out.println("Does " + n + " have exactly one pair of consecutive set bits? " + result);

        ExactlyOneConsecutiveSetBitsPair solution2 = new ExactlyOneConsecutiveSetBitsPair();
        int n2 = 6;
        boolean result2 = solution2.consecutiveSetBits(n2);
        System.out.println("Does " + n2 + " have exactly one pair of consecutive set bits? " + result2);

        ExactlyOneConsecutiveSetBitsPair solution3 = new ExactlyOneConsecutiveSetBitsPair();
        int n3 = 7;
        boolean result3 = solution3.consecutiveSetBits(n3);
        System.out.println("Does " + n3 + " have exactly one pair of consecutive set bits? " + result3);
    
    }
    
}
