public class MinimumMovestoMakeArrayComplementary {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        // Difference array to track move changes
        int[] delta = new int[2 * limit + 2];

        // Process each mirrored pair
        for (int i = 0; i < n/2; i++){
            int a = Math.min(nums[i],nums[n-1-i]);
            int b = Math.max(nums[i], nums[n-1-i]);

            // Initially assume: Every target sum needs 2 moves

            // Add +2 moves for all sums starting from 2
            delta[2] += 2;
            // reduce moves from 2 -> 1 for sums in range [a + 1, b + limit]
            delta[a+1]--;
            // Reduce moves from 1 -> 0 for 
            delta[a+b]--;
            // Restore after exact sum
            delta[a+b+1]++;
            // Stop reducing after (b + limit)
            delta[b+limit+1]++;
        }

        // Maximum possible answer = n
        int res = n, moves = 0;

        // Prefix sum over all target sums
        for (int t = 2; t <= limit*2; t++){
            // Current total moves needed for this target sum
            moves += delta[t];
            res = Math.min(res,moves);
        }

        return res;
        
    }

    public static void main(String[] args) {
        MinimumMovestoMakeArrayComplementary sol = new MinimumMovestoMakeArrayComplementary();
        int[] nums = {1,2,4,3};
        int limit = 4;
        int ans = sol.minMoves(nums, limit);
        System.out.println(ans);

        MinimumMovestoMakeArrayComplementary sol2 = new MinimumMovestoMakeArrayComplementary();
        int[] nums2 = {1,2,2,1};
        int limit2 = 2;
        int ans2 = sol2.minMoves(nums2, limit2);
        System.out.println(ans2);
        
        MinimumMovestoMakeArrayComplementary sol3 = new MinimumMovestoMakeArrayComplementary();
        int[] nums3 = {1,2,1,2};
        int limit3 = 2;
        int ans3 = sol3.minMoves(nums3, limit3);
        System.out.println(ans3);
    }
    
}
