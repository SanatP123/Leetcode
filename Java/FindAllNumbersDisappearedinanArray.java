import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        // Mark numbers that exist by making the value at their index negative
        for (int i = 0; i < n; i++){
            int index = Math.abs(nums[i]) - 1;
            // Mark as visited only if not already negative
            if (nums[index] > 0){
                nums[index] = -nums[index];
            }
        }    

        // Positive values mean the index+1 number was never seen in the array
        for (int i = 0; i < n; i++){
            if (nums[i] > 0){
                ans.add(i+1);
            }
        }    
        return ans;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedinanArray sol = new FindAllNumbersDisappearedinanArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> ans = sol.findDisappearedNumbers(nums);
        for (int num : ans){
            System.out.print(num + " ");
        }

        System.out.println();

        FindAllNumbersDisappearedinanArray sol2 = new FindAllNumbersDisappearedinanArray();
        int[] nums2 = {1,1};
        List<Integer> ans2 = sol2.findDisappearedNumbers(nums2);
        for (int num : ans2){
            System.out.print(num + " ");
        }
    }
    
}
