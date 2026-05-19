
import java.util.*;
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        /**
        A brute force approach would be checking every pair using two loops, which gives us O(n²) time complexity.
        Since repeated lookups are expensive that way, we can instead use a HashSet, which provides average O(1) lookup time.
        As we iterate through the array, we check whether the current number already exists in the set. If it does, we return true; otherwise, we add it to the set.
        This reduces the overall time complexity to O(n) with O(n) extra space.
        */

        // Stores values which are already seen
        HashSet<Integer> seen = new HashSet<>();


        for (int num : nums){
            // If num exists in the set return true as it appears twice
            if (seen.contains(num)){
                return true;
            }

            // Populate already seen nums
            seen.add(num);
        }

        return false;
        
    }

    public static void main(String[] args) {
        ContainsDuplicate sol = new ContainsDuplicate();
        int[] nums = {1,2,3,1};
        boolean ans = sol.containsDuplicate(nums);
        System.out.println(ans);

        ContainsDuplicate sol2 = new ContainsDuplicate();
        int[] nums2 = {1,2,3,4};
        boolean ans2 = sol2.containsDuplicate(nums2);
        System.out.println(ans2);

        ContainsDuplicate sol3 = new ContainsDuplicate();
        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
        boolean ans3 = sol3.containsDuplicate(nums3);
        System.out.println(ans3);
    }
}