

public class JumpGameII {
    
    public int jump(int[] nums) {
        int n = nums.length;
        
        // farthest index reachable with one more jump from this range
        int curFar = 0;

        // end of the range reachable with current number of jumps
        int curEnd = 0;
        int res = 0;

        for (int i = 0; i < n-1; i++){
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);
           
            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                res++;
                curEnd = curFar;
            }
        }

        return res;
        
    }

    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();
        int[] nums = {2,3,1,1,4};
        int result = solution.jump(nums);
        System.out.println("Minimum number of jumps: " + result);

        JumpGameII solution2 = new JumpGameII();
        int[] nums2 = {2,3,0,1,4};
        int result2 = solution2.jump(nums2);
        System.out.println("Minimum number of jumps: " + result2);

        JumpGameII solution3 = new JumpGameII();
        int[] nums3 = {0};
        int result3 = solution3.jump(nums3);
        System.out.println("Minimum number of jumps: " + result3);
    }
}
