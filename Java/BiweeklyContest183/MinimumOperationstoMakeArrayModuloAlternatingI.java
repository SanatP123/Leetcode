package BiweeklyContest183;
class MinimumOperationstoMakeArrayModuloAlternatingI {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;

        int res = Integer.MAX_VALUE;

        // Try all possible remainder pairs (even=i, odd=j)
        for (int i = 0; i < k; i++){
            for (int j = 0; j < k; j++){
                if (i == j) continue;

                int ans = 0;

                for (int x = 0; x < n; x++){
                    int target;
                    if (x % 2 == 0){
                        target = i;
                    }
                    else{
                        target = j;
                    }

                     // Cost to change current remainder to target remainder
                    int diff = Math.abs((nums[x] % k) - target);
                    ans += Math.min(diff, k - diff);
                    
                }


                // Keep minimum total cost
                res = Math.min(res,ans);
            }
        }

        return res;
        
    }

    public static void main(String[] args) {
        
        MinimumOperationstoMakeArrayModuloAlternatingI solution = new MinimumOperationstoMakeArrayModuloAlternatingI();
        int[] nums = {1,4,2,8};
        int k = 3;
        int result = solution.minOperations(nums, k);
        System.out.println("Minimum operations to make array modulo alternating: " + result);

        MinimumOperationstoMakeArrayModuloAlternatingI solution2 = new MinimumOperationstoMakeArrayModuloAlternatingI();
        int[] nums2 = {1,1,1};
        int k2 = 3;
        int result2 = solution2.minOperations(nums2, k2);
        System.out.println("Minimum operations to make array modulo alternating: " + result2);

        MinimumOperationstoMakeArrayModuloAlternatingI solution3 = new MinimumOperationstoMakeArrayModuloAlternatingI();    
        int[] nums3 = {1,2,3};
        int k3 = 4;
        int result3 = solution3.minOperations(nums3, k3);
        System.out.println("Minimum operations to make array modulo alternating: " + result3);
    }
}