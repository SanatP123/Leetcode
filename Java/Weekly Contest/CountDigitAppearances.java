
public class CountDigitAppearances {
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans = 0;

        for (int num : nums){
            String n = String.valueOf(num); 
            ans += check_appearances(n, digit);
        }

        return ans;

        
    }

    // Helper function which returns the total count of the digit in a number
    public int check_appearances(String num, int digit){
        int count = 0;
        // TypeCasting to char
        char dig = (char)(digit + '0');
        for (char c: num.toCharArray()){
            if (c == dig){
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountDigitAppearances solution = new CountDigitAppearances();

        // Test case 1
        int[] nums1 = {12,54,32,22};
        int digit1 = 2;
        System.out.println("Test 1: " + solution.countDigitOccurrences(nums1, digit1));  // Expected: 8

        // Test case 2
        int[] nums2 = {1,34,7};
        int digit2 = 9;
        System.out.println("Test 2: " + solution.countDigitOccurrences(nums2, digit2));  // Expected: 0

        // Test case 3
        int[] nums3 = {100, 200, 300};
        int digit3 = 0;
        System.out.println("Test 3: " + solution.countDigitOccurrences(nums3, digit3));  // Expected: 6

        // Test case 4
        int[] nums4 = {111, 222, 333};
        int digit4 = 1;
        System.out.println("Test 4: " + solution.countDigitOccurrences(nums4, digit4));  // Expected: 3
    }
    
}
