import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // Track previous element
        int prev = lower;

        for (int i = 0; i < nums.length; i++){
            // Add missing numbers
            if (nums[i] > prev){
                res.add(new ArrayList<>(Arrays.asList(prev, nums[i] - 1)));
            }

            // Update previous 
            prev = nums[i] + 1;
        }

        // Handle last range
        if (prev <= upper){
            res.add(new ArrayList<>(Arrays.asList(prev, upper)));
        }

        return new ArrayList<>(res);
        
    }

    public static void main(String[] args) {
        MissingRanges sol = new MissingRanges();
        int[] nums = {0,1,3,50,75};
        int lower = 0;
        int upper = 99;
        List<List<Integer>> ans = sol.findMissingRanges(nums, lower, upper);
        System.out.println(ans);

        MissingRanges sol2 = new MissingRanges();
        int[] nums2 = {-1};
        int lower2 = -1;
        int upper2 = -1;
        List<List<Integer>> ans2 = sol2.findMissingRanges(nums2, lower2, upper2);
        System.out.println(ans2);

        MissingRanges sol3 = new MissingRanges();
        int[] nums3 = {1000000000};
        int lower3 = 0;
        int upper3 = 1000000000;
        List<List<Integer>> ans3 = sol3.findMissingRanges(nums3, lower3, upper3);
        System.out.println(ans3);
    }
    
}
