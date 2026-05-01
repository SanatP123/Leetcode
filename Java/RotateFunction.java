public class RotateFunction {
    public int maxRotateFunction(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        int f = 0;

        // compute sum and F(0)
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            f += i * nums[i];
        }

        // Consider f(0) as maximum value and compare
        int res = f;
        for (int k = 1; k < n; k++){
            // F[1] = F[0] + sum - last element * last k
            // Everything increases by sum, except one element which resets
            f = f + sum - (nums[n-k] * n);
            res = Math.max(res,f);
        }
        
        return res;
    }

    public static void main(String[] args) {
        RotateFunction sol = new RotateFunction();
        int[] nums = {4,3,2,6};
        int ans = sol.maxRotateFunction(nums);
        System.out.println(ans);

        RotateFunction sol2 = new RotateFunction();
        int[] nums2 = {100};
        int ans2 = sol2.maxRotateFunction(nums2);
        System.out.println(ans2);
    }
    
}
