public class MaximumDistanceBetweenaPairofValues {
    public int maxDistance(int[] nums1, int[] nums2) {
        int distance = 0;
        int n1 =  nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;

        
        while (i < n1 && j < n2){

            // If nums1[i] <= nums2[j], it's a valid pair
            if (nums1[i] <= nums2[j])         {
                distance = Math.max(distance, j - i);
                j++;
            }
            
            // Need smaller nums1[i]
            else{
                i++;
            }

        }

        return distance;
        
    }

    public static void main(String[] args) {
        MaximumDistanceBetweenaPairofValues solution = new MaximumDistanceBetweenaPairofValues();
        // Test case 1
        int[] nums1_1 = {55,30,5,4,2};
        int[] nums2_1 = {100,20,10,10,5};
        System.out.println("Test 1: " + solution.maxDistance(nums1_1, nums2_1));  // Expected: 2

        // Test case 2
        int[] nums1_2 = {2,2,2};
        int[] nums2_2 = {10,10,1};
        System.out.println("Test 2: " + solution.maxDistance(nums1_2, nums2_2));  // Expected: 3

        // Test case 3
        int[] nums1_3 = {30,29,19,5};
        int[] nums2_3 = {25,25,25,25,25};
        System.out.println("Test 3: " + solution.maxDistance(nums1_3, nums2_3));  // Expected: 0
    }
    
}
