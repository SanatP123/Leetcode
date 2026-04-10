public class MinimumDistanceBetweenThreeEqualElementsI {
    public int minimumDistance(int[] nums) {
        // Maximum Value
        int res = Integer.MAX_VALUE;
        int n = nums.length;

        // Good tuples cannot exist
        if (n < 3){
            return -1;
        }

        
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                for (int k = j+1; k < n; k++){
                    if (nums[i] == nums[j] && nums[j] == nums[k]){
                        res = Math.min(res, Math.abs(i-j) + Math.abs(j-k) + Math.abs(k-i));
                    }
                }
            }
        }

        // No good tuples exist in the array
        if (res == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return res;
        }
        
    }

    public static void main(String[] args) {
        MinimumDistanceBetweenThreeEqualElementsI solution = new MinimumDistanceBetweenThreeEqualElementsI();

        // Test case 1
        int[] nums1 = {1,2,1,1,3};
        System.out.println("Test 1: " + solution.minimumDistance(nums1));  // Expected: 4

        // Test case 2
        int[] nums2 = {1,1,2,3,2,1,2};
        System.out.println("Test 2: " + solution.minimumDistance(nums2));  // Expected: -1

        // Test case 3
        int[] nums3 = {1};
        System.out.println("Test 3: " + solution.minimumDistance(nums3));  // Expected: 2

        // Test case 4
        int[] nums4 = {5, 5, 5};
        System.out.println("Test 4: " + solution.minimumDistance(nums4));  // Expected: 4
    }
}


