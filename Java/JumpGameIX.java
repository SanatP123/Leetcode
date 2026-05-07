public class JumpGameIX {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Prefix maximum
        int[] preMax = new int[n];
        preMax[0] = nums[0];

        for (int i = 1; i < n; i++){
            preMax[i] = Math.max(preMax[i-1],nums[i]);
        }

        int sufMin = Integer.MAX_VALUE;

        // Traverse from right to left
        for (int j = n-1; j >= 0; j--){
            if (preMax[j] > sufMin){
                ans[j] = ans[j+1];
            }
            else{
                ans[j] = preMax[j];
            }
            sufMin = Math.min(sufMin,nums[j]);
        }

        return ans;

        
    }

    public static void main(String[] args) {
        JumpGameIX sol = new JumpGameIX();
        int[] nums = {2,1,3};
        int[] ans = sol.maxValue(nums);
        for (int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }

        JumpGameIX sol2 = new JumpGameIX();
        int[] nums2 = {2,3,1};
        int[] ans2 = sol2.maxValue(nums2);
        System.out.println();
        for (int i = 0; i < ans2.length; i++){
            System.out.print(ans2[i] + " ");    
        }
    }
    
}
