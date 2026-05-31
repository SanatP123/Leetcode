public class DigitFrequencyStore {
    public int digitFrequencyScore(int n) {
        int[] freq = new int[10];

        while (n > 0){
            int digit = n % 10;
            freq[digit] += 1;
            n = n / 10;
        }

        int score = 0;

        for (int i = 0; i < 10; i++){
            score += i * freq[i];
        }
 
        return score;
        
    }

    public static void main(String[] args) {
        DigitFrequencyStore solution = new DigitFrequencyStore();
        int n = 122;
        int result = solution.digitFrequencyScore(n);
        System.out.println("Digit frequency score: " + result);

        DigitFrequencyStore solution2 = new DigitFrequencyStore();
        int n2 = 101;
        int result2 = solution2.digitFrequencyScore(n2);
        System.out.println("Digit frequency score: " + result2);

        DigitFrequencyStore solution3 = new DigitFrequencyStore();
        int n3 = 12345;
        int result3 = solution3.digitFrequencyScore(n3);
        System.out.println("Digit frequency score: " + result3);
    }
    
}
