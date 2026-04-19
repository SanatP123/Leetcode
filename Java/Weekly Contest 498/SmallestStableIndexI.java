public class SmallestStableIndexI {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefix_max = new int[n];
        int[] suffix_min = new int[n];

        // Initialize boundaries
        prefix_max[0] = nums[0];
        suffix_min[n-1] = nums[n-1];

        // Build prefix max array
        for (int i = 1; i < n; i++){
            prefix_max[i] = Math.max(prefix_max[i-1], nums[i]);
        }

        // Build suffix min array
        for (int j = n-2; j >= 0; j--){
            suffix_min[j] = Math.min(suffix_min[j+1], nums[j]);
        }

        // Find first index where condition holds
        for (int a = 0; a < n; a++){
            if (prefix_max[a] - suffix_min[a] <= k){
                // Smallest valid index
                return a;
            }
        }

        // No valid index found
        return -1;
        
    }

    public static void main(String[] args) {
        SmallestStableIndexI solution = new SmallestStableIndexI();
        // Test case 1
        int[] nums1 = {5,0,1,4};
        int k1 = 3;
        System.out.println("Test 1: " + solution.firstStableIndex(nums1, k1));  // Expected: 2

        // Test case 2
        int[] nums2 = {3,2,1};
        int k2 = 1;
        System.out.println("Test 2: " + solution.firstStableIndex(nums2, k2));  // Expected: -1

        // Test case 3
        int[] nums3 = {0};
        int k3 = 0;
        System.out.println("Test 3: " + solution.firstStableIndex(nums3, k3));  // Expected: 0
    }
    
}
