
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // Index for placing next non-val element
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                // Keep element
                nums[k] = nums[i];
                k += 1;
            }
        }
        // Number of valid elements
        return k;
        
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();

        // Test case 1
        int[] nums1 = {3,2,2,3};
        int val1 = 3;
        int newLength1 = solution.removeElement(nums1, val1);
        System.out.println("Test 1: New Length = " + newLength1);  // Expected: 2

        // Test case 2
        int[] nums2 = {0,1,2,2,3,0,4,2};
        int val2 = 2;
        int newLength2 = solution.removeElement(nums2, val2);
        System.out.println("Test 2: New Length = " + newLength2);  // Expected: 5

        // Test case 3
        int[] nums3 = {1};
        int val3 = 1;
        int newLength3 = solution.removeElement(nums3, val3);
        System.out.println("Test 3: New Length = " + newLength3);  // Expected: 0
    }
}