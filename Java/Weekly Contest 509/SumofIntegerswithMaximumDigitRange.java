

public class SumofIntegerswithMaximumDigitRange {
    public int maxDigitRange(int[] nums) {
        int n = nums.length;
        int maxRange = 0;
        int sum = 0;

        for (int i = 0; i < n; i++){
            int currentRange = getDigitRange(nums[i]);
            
            if (currentRange > maxRange){
                maxRange = currentRange;
                sum = nums[i];
            }
            else if (currentRange == maxRange){
                sum += nums[i];
            }
        }
        
        return sum;
        
    }
    private int getDigitRange(int n){
        int largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;
        while (n > 0){
            int digit = n % 10;
            largest = Math.max(largest, digit);
            smallest = Math.min(smallest, digit);
            n = n / 10;
        }

        return largest - smallest;

    }

    public static void main(String[] args) {
        SumofIntegerswithMaximumDigitRange solution = new SumofIntegerswithMaximumDigitRange();
        int[] nums1 = {5724,111,350};
        System.out.println("Sum of integers with maximum digit range: " + solution.maxDigitRange(nums1)); // Output: 1368

        int[] nums2 = {90,900};
        System.out.println("Sum of integers with maximum digit range: " + solution.maxDigitRange(nums2)); // Output: 90
    }
    
}
