

public class MaximumTotalValueofCoveredIndices {
   
    public long maxTotal(int[] nums, String s) {
        int n = nums.length;
        long total = 0;
        int i = 0;

        // Process the first contiguous block of '1's
        while (i < n && s.charAt(i) == '1'){
            total += nums[i];
            i++;
        }

        while (i < n){
            if (s.charAt(i) == '0'){
                i++;
                continue;
            }
            int minVal = nums[i-1];
            // Track the sum of the block
            total += nums[i-1];

            while (i < n && s.charAt(i) == '1'){
                // Track the minimum value in that block
                minVal = Math.min(minVal, nums[i]);
                // Add all values in the block to total
                total += nums[i];
                i++;
            }

            // Subtract the minimum value once 
            total -= minVal;
        } 

        return total;
    }

    public static void main(String[] args) {
        MaximumTotalValueofCoveredIndices solution = new MaximumTotalValueofCoveredIndices();
        int[] nums = {9,2,6,1};
        String s = "0101";
        long result = solution.maxTotal(nums, s);
        System.out.println("Maximum total value of covered indices: " + result);

        MaximumTotalValueofCoveredIndices solution2 = new MaximumTotalValueofCoveredIndices();
        int[] nums2 = {5,1,4};
        String s2 = "001";
        long result2 = solution2.maxTotal(nums2, s2);
        System.out.println("Maximum total value of covered indices: " + result2);

        MaximumTotalValueofCoveredIndices solution3 = new MaximumTotalValueofCoveredIndices();
        int[] nums3 = {9,3,5};
        String s3 = "011";
        long result3 = solution3.maxTotal(nums3, s3);
        System.out.println("Maximum total value of covered indices: " + result3);
    
    }
    
}
