

public class SumofCompatibleNumbersinRangeI {
    
    public int sumOfGoodIntegers(int n, int k) {
        int sum = 0;

        // Check all positive integers x such that |n - x| <= k
        for (int x = Math.max(1,n-k); x <= n+k; x++){

            // Compatible if n and x have no common set bits
            if ((n & x) == 0){
                sum += x;
            }
        }

        return sum;
        
    }

    public static void main(String[] args) {
        SumofCompatibleNumbersinRangeI solution = new SumofCompatibleNumbersinRangeI();
        int n = 2;
        int k = 3;
        int result = solution.sumOfGoodIntegers(n, k);
        System.out.println(result); // Output: 10

        SumofCompatibleNumbersinRangeI solution2 = new SumofCompatibleNumbersinRangeI();
        int n2 = 5;
        int k2 = 1;
        int result2 = solution2.sumOfGoodIntegers(n2, k2);
        System.out.println(result2); // Output: 0
    }
    
}
