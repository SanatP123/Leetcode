import java.util.Arrays;

public class NumberofZigZagArraysI {
    private static final int MOD = 1000000007;
    public int zigZagArrays(int n, int l, int r) {
        int numberOfZigzag = 0;

        // Total number of distinct values available
        int m = r - l + 1;

        // dp[j] = number of valid arrays ending with value j
        int[] dp = new int[m];

        // Every value can form an array of length 1
        Arrays.fill(dp,1);

        // Build arrays of length 2 to n
        for (int i = 2; i <= n; i++){
            int sum = 0;

             // Even positions must continue one alternating pattern
            // (< > < > ...)
            if (i % 2 == 0){
                for (int j = 0; j < m; j++){
                    int t = dp[j];
                    // Arrays ending at j can only come from smaller values
                    dp[j] = sum;
                    // Prefix sum of previous states
                    sum = (sum + t) % MOD;
                }
            }

             // Odd positions continue the opposite direction
            // (> < > < ...)
            else{
                for (int j = m - 1; j >= 0; j--){
                    int t = dp[j];
                    // Arrays ending at j can only come from larger values
                    dp[j] = sum;
                     // Suffix sum of previous states
                    sum = (sum + t) % MOD;
                }
            }
        }

        // Sum all arrays ending at any value
        for (int j = 0; j < m; j++){
            numberOfZigzag = (numberOfZigzag + dp[j]) % MOD;
        }

          // Multiply by 2 to account for both possible starting patterns:
        return (numberOfZigzag * 2) % MOD;

        
    }

    public static void main(String[] args) {
        NumberofZigZagArraysI solution = new NumberofZigZagArraysI();
        int n = 3;
        int l = 1;
        int r = 3;
        int result = solution.zigZagArrays(n, l, r);
        System.out.println(result); // Output: 10

        NumberofZigZagArraysI solution2 = new NumberofZigZagArraysI();
        int n2 = 3;
        int l2 = 4;
        int r2 = 5;
        int result2 = solution2.zigZagArrays(n2, l2, r2);
        System.out.println(result2); // Output: 2
    }
}
