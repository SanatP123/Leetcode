import java.util.HashMap;

public class TwoSum {
    
    public int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return ans;

        
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = sol.twoSum(nums, target);
        for (int i : ans){
            System.out.print(i + " ");
        }
        System.out.println();

        TwoSum sol2 = new TwoSum();
        int[] nums2 = {3,2,4};
        int target2 = 6;
        int[] ans2 = sol2.twoSum(nums2, target2);
        for (int i : ans2){
            System.out.print(i + " ");
        }
        System.out.println();

        TwoSum sol3 = new TwoSum();
        int[] nums3 = {3,3};
        int target3 = 6;
        int[] ans3 = sol3.twoSum(nums3, target3);
        for (int i : ans3){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
    

