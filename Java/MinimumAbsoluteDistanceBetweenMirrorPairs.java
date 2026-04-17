import java.util.HashMap;

public class MinimumAbsoluteDistanceBetweenMirrorPairs {
    public int minMirrorPairDistance(int[] nums) {

        // HashMap to track values and indices
        HashMap<Integer,Integer> map = new HashMap<>();
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++){
            int current = nums[i];
            
            
            if (map.containsKey(current)){
                // Minimum absolute difference
                distance = Math.min(distance, Math.abs(i - map.get(current)));
            }

            map.put(return_reverse(nums[i]),i);
        }

        // If no pair exists return -1
        return distance == Integer.MAX_VALUE ? -1 : distance;
    }

    // Helper function that returns reverse of nums[i]
        public int return_reverse(int a){
            // Reversed number
            int rev = 0;
            // Remainder
            int rem;

            if (a == 0) return 0;

            while (a > 0){
                rem = a % 10; 
                rev = (rev * 10) + rem;
                a = a / 10;
            }
            return rev;
            }

    public static void main(String[] args) {
        MinimumAbsoluteDistanceBetweenMirrorPairs solution = new MinimumAbsoluteDistanceBetweenMirrorPairs();
        // Test case 1
        int[] nums1 = {12,21,45,33,54};
        System.out.println("Test 1: " + solution.minMirrorPairDistance(nums1));  // Expected: 1         


        // Test case 2
        int[] nums2 = {120,21};
        System.out.println("Test 2: " + solution.minMirrorPairDistance(nums2));  // Expected: 1

        // Test case 3
        int[] nums3 = {21,120};
        System.out.println("Test 3: " + solution.minMirrorPairDistance(nums3));  // Expected: -1
    }
        
    
            
}
