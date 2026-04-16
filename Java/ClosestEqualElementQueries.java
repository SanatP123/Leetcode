import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ClosestEqualElementQueries {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = queries.length;
        int[] ans = new int[n];
        

        // Build map: value -> list of indices
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
                map.get(nums[i]).add(i);
        }

        // Sort indices for each value
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        for (int q = 0; q < n; q++){
            int current_idx = queries[q];
            int current_value = nums[current_idx];
            List<Integer> all_indexes = map.get(current_value);

            // If only one occurrence, answer is -1
            if (all_indexes.size() == 1){
                ans[q] = -1;
                continue;
            }

            int left = 0;
            int right = all_indexes.size() - 1;
            int pos = -1;

            // Binary search to find position of current index
            while (left <= right){
                int mid = (left + right)/2;

                if (all_indexes.get(mid) == current_idx){
                    pos = mid;
                    break;
                }
                else if (all_indexes.get(mid) > current_idx){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }

            int size = all_indexes.size();

            // Get circular neighbors
            int leftIdx = all_indexes.get((pos - 1 + size) % size);
            int rightIdx = all_indexes.get((pos + 1) % size);

            // Compute circular distances
            int distLeft = Math.min(Math.abs(current_idx - leftIdx),
                                    nums.length - Math.abs(current_idx - leftIdx));

            int distRight = Math.min(Math.abs(current_idx - rightIdx),
                                     nums.length - Math.abs(current_idx - rightIdx));

            // Take minimum distance
            ans[q] = Math.min(distLeft,distRight);                         
            
        }

        // Convert array to List
        List<Integer> result = new ArrayList<>();
        for (int x : ans) result.add(x);

        return result;

        
    }

    public static void main(String[] args) {
        ClosestEqualElementQueries solution = new ClosestEqualElementQueries();

        // Test case 1
        int[] nums1 = {1,3,1,4,1,3,2};
        int[] queries1 = {0,3,5};
        System.out.println("Test 1: " + solution.solveQueries(nums1, queries1));  // Expected: [4, 3, 2, 1, 3]

        // Test case 2
        int[] nums2 = {1,2,3,4};
        int[] queries2 = {0,1,2,3};
        System.out.println("Test 2: " + solution.solveQueries(nums2, queries2));  // Expected: [-1,-1,-1,-1]

        // Test case 3
        int[] nums3 = {1,2,3,4,5};
        int[] queries3 = {0,1,2,3,4};
        System.out.println("Test 3: " + solution.solveQueries(nums3, queries3));  // Expected: [-1,-1,-1,-1,-1]
    }
    
}
