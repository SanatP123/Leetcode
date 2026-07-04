

public class MaximumValidPairSum {
    
    public int maxValidPairSum(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int bestLeft = nums[0];
        
        for (int j = k; j < n; j++){
            // j - i >= k -> i <= j - k
            bestLeft = Math.max(bestLeft, nums[j-k]);
            res = Math.max(res, bestLeft + nums[j]);
            
        }

        return res;
        
    }

    public static void main(String[] args) {
        MaximumValidPairSum solution = new MaximumValidPairSum();
        int[] nums1 = {1,3,5,2,8};
        int k1 = 2;
        System.out.println("Maximum valid pair sum: " + solution.maxValidPairSum(nums1, k1)); // Output: 9

        int[] nums2 = {5,1,9};
        int k2 = 1;
        System.out.println("Maximum valid pair sum: " + solution.maxValidPairSum(nums2, k2)); // Output: 10
    }
    
}
