public class LeftAndRightSumDifferences {
   
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int totalSum = 0;
        for (int i = 0; i < n; i++){
            totalSum += nums[i];
        }

        int leftSum = 0;
        int rightSum = totalSum;

        for (int i = 0; i < n; i++){
            // Remove current element from right side
            rightSum -= nums[i];

            // Difference between left and right sums
            ans[i] = Math.abs(leftSum - rightSum);

            // Add current element to left side
            leftSum += nums[i];
        }

        return ans;
        
    }

    public static void main(String[] args) {
        LeftAndRightSumDifferences solution = new LeftAndRightSumDifferences();
        int[] nums = {10, 4, 8, 3};
        int[] result = solution.leftRightDifference(nums);
        System.out.print("Left and right sum differences: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        LeftAndRightSumDifferences solution2 = new LeftAndRightSumDifferences();
        int[] nums2 = {1};
        int[] result2 = solution2.leftRightDifference(nums2);
        System.out.print("Left and right sum differences: ");
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println();
    
    }
    
}
