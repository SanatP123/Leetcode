

public class CheckGoodInteger {
    public boolean checkGoodInteger(int n) {
        int digitSum = 0, squareSum = 0;
        while (n > 0){
            int digit = n % 10;
            digitSum += digit;
            squareSum += digit * digit;
            n = n / 10;
        }

        return (squareSum - digitSum) >= 50;

    }

    public static void main(String[] args){
        CheckGoodInteger solution = new CheckGoodInteger();
        int n = 1000;
        boolean result = solution.checkGoodInteger(n);
        System.out.println(result); // Output: false

        CheckGoodInteger solution2 = new CheckGoodInteger();
        int n2 = 19;
        boolean result2 = solution2.checkGoodInteger(n2);
        System.out.println(result2); // Output: true
    }
}
