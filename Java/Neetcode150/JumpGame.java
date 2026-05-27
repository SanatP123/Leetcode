

public class JumpGame {
    
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0; // farthest reachable index so far

        for (int i = 0; i < n; i++){

            // Cannot even reach this position
            if (i > farthest) return false;

            // Extend reachable range
            farthest = Math.max(farthest, i + nums[i]);
        }

        // Can reach or pass the last index
        return farthest >= n-1;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        int[] nums = {2,3,1,1,4};
        boolean result = solution.canJump(nums);
        System.out.println("Can jump to end of array: " + result);

        JumpGame solution2 = new JumpGame();
        int[] nums2 = {3,2,1,0,4};
        boolean result2 = solution2.canJump(nums2);
        System.out.println("Can jump to end of array: " + result2);

        JumpGame solution3 = new JumpGame();
        int[] nums3 = {0};
        boolean result3 = solution3.canJump(nums3);
        System.out.println("Can jump to end of array: " + result3);
    }
    
}
