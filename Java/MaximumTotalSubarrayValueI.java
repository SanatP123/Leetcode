public class  MaximumTotalSubarrayValueI {
    
    public long maxTotalValue(int[] nums, int k) {

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

         // Find the global maximum and minimum
        for (int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int value = max - min;
        // Reuse the best subarray k times
        return (long)value * k;
        
    }

    public static void main(String[] args) {
        MaximumTotalSubarrayValueI solution = new MaximumTotalSubarrayValueI();
        int[] nums = {1, 3, 2};
        int k = 2;
        long result = solution.maxTotalValue(nums, k);
        System.out.println(result); // Output: 4

        MaximumTotalSubarrayValueI solution2 = new MaximumTotalSubarrayValueI();
        int[] nums2 = {4, 2, 5, 1};
        int k2 = 3;
        long result2 = solution2.maxTotalValue(nums2, k2);
        System.out.println(result2); // Output: 12
    }
    
}
