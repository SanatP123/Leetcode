import java.util.HashMap;
import java.util.Map;

public class MinimumDistanceBetweenThreeEqualElementsII {
    public int minimumDistance(int[] nums) {

        // Map to store for each number:
        // pair[0] = second last index (prev)
        // pair[1] = last index
        Map<Integer, int[]> mp = new HashMap<>();
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++){
            // If this number appears for the first time
            if (!mp.containsKey(nums[i])){
                
                // Store: no previous index yet (-1), and current index as last
                mp.put(nums[i], new int[]{-1, i});
            }
            else{

                // Retrieve previous two indices for this number
                int[] pair = mp.get(nums[i]);
                int prev = pair[0];
                int last = pair[1];

                // If we already have at least 2 previous occurrences,
                // we can form a triplet (prev, last, i)
                if (prev != -1){
                    int a = prev;
                    int b = last;
                    int c = i;
                    
                     // 2 * (max index - min index)
                    // int diff = 2 * (Math.max(a, Math.max(b,c)) - Math.min(a, Math.min(b,c)));
                    int diff = 2 * (c - a);

                    mini = Math.min(mini, diff);
                } 
                
                // Update indices
                pair[0] = last;
                pair[1] = i;
                
            }
        }

        return mini == Integer.MAX_VALUE ? -1 : mini;
    }

    public static void main(String[] args) {
        MinimumDistanceBetweenThreeEqualElementsII solution = new MinimumDistanceBetweenThreeEqualElementsII();

        // Test case 1
        int[] nums1 = {1,2,1,1,3};
        System.out.println("Test 1: " + solution.minimumDistance(nums1));  // Expected: 4

        // Test case 2
        int[] nums2 = {1,1,2,3,2,1,2};
        System.out.println("Test 2: " + solution.minimumDistance(nums2));  // Expected: -1

        // Test case 3
        int[] nums3 = {1};
        System.out.println("Test 3: " + solution.minimumDistance(nums3));  // Expected: -1

        // Test case 4
        int[] nums4 = {5, 5, 5};
        System.out.println("Test 4: " + solution.minimumDistance(nums4));  // Expected: 4
    }
    
}
