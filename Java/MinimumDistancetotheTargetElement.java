public class MinimumDistancetotheTargetElement {
    public int getMinDistance(int[] nums, int target, int start) {
        int minAbs = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target){
                minAbs = Math.min(minAbs, Math.abs(i - start));
            }
        }

        return minAbs;
        
    }

    public static void main(String[] args) {
        MinimumDistancetotheTargetElement solution = new MinimumDistancetotheTargetElement();

        // Test case 1
        int[] nums1 = {1,2,3,4,5};
        int target1 = 5;
        int start1 = 3;
        System.out.println("Test 1: " + solution.getMinDistance(nums1, target1, start1));  // Expected: 1

        // Test case 2
        int[] nums2 = {1};
        int target2 = 1;
        int start2 = 0;
        System.out.println("Test 2: " + solution.getMinDistance(nums2, target2, start2));  // Expected: 0

        // Test case 3
        int[] nums3 = {1,1,1,1,1,1,1,1,1,1};
        int target3 = 1;
        int start3 = 0;
        System.out.println("Test 3: " + solution.getMinDistance(nums3, target3, start3));  // Expected: 0
    }
    
}
