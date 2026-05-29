class MinimumElementAfterReplacementWithDigitSum {
    public int minElement(int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            int currentSum = digitSum(nums[i]);
            res = Math.min(res, currentSum);
        }

        return res;
        
        
    }

    int digitSum(int n){
        int sum = 0;
        while (n > 0){
            sum += n % 10;
            n = n / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        MinimumElementAfterReplacementWithDigitSum solution = new MinimumElementAfterReplacementWithDigitSum();
        int[] nums = {10,12,13,14};
        int result = solution.minElement(nums);
        System.out.println("Minimum element after replacement with digit sum: " + result);

        MinimumElementAfterReplacementWithDigitSum solution2 = new MinimumElementAfterReplacementWithDigitSum();
        int[] nums2 = {1,2,3,4};
        int result2 = solution2.minElement(nums2);
        System.out.println("Minimum element after replacement with digit sum: " + result2);

        MinimumElementAfterReplacementWithDigitSum solution3 = new MinimumElementAfterReplacementWithDigitSum();
        int[] nums3 = {999,19,199};
        int result3 = solution3.minElement(nums3);
        System.out.println("Minimum element after replacement with digit sum: " + result3);
    }
}