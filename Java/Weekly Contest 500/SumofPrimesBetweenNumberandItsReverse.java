

public class SumofPrimesBetweenNumberandItsReverse {
    public int sumOfPrimesInRange(int n) {

        // Reverse using StringBuilder (O(n))
        String reversed = new StringBuilder(Integer.toString(n)).reverse().toString();
        int r = Integer.parseInt(reversed);

        int minDigit = Math.min(n,r);
        int maxDigit = Math.max(n,r);

        int sum = 0;

        // Check each number in range
        for (int i = minDigit; i <= maxDigit; i++){
            if (check_prime(i)){
                sum += i;
            }
        }

        return sum;


        
    }

    // Helper function to check primes
    public boolean check_prime(int number){
        if (number < 2){
            return false;
        }
        for (int i = 2; i * i <= number; i++){
            if (number % i == 0){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        SumofPrimesBetweenNumberandItsReverse sol = new SumofPrimesBetweenNumberandItsReverse();
        int n = 13;
        int ans = sol.sumOfPrimesInRange(n);
        System.out.println(ans);

        SumofPrimesBetweenNumberandItsReverse sol2 = new SumofPrimesBetweenNumberandItsReverse();
        int n2 = 10;
        int ans2 = sol2.sumOfPrimesInRange(n2);
        System.out.println(ans2);

        SumofPrimesBetweenNumberandItsReverse sol3 = new SumofPrimesBetweenNumberandItsReverse();
        int n3 = 8;
        int ans3 = sol3.sumOfPrimesInRange(n3);
        System.out.println(ans3);
    }
    
}
