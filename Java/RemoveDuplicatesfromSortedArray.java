
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        // First element always unique
        int k = 1;

        for (int i = 1; i < nums.length; i++){
            // Next unique element
            if (nums[i] != nums[k-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray solution = new RemoveDuplicatesfromSortedArray();

        // Test case 1
        int[] nums1 = {1,1,2};
        int newLength1 = solution.removeDuplicates(nums1);
        System.out.println("Test 1: New Length = " + newLength1);  // Expected: 2

        // Test case 2
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int newLength2 = solution.removeDuplicates(nums2);
        System.out.println("Test 2: New Length = " + newLength2);  // Expected: 5

        // Test case 3
        int[] nums3 = {1};
        int newLength3 = solution.removeDuplicates(nums3);
        System.out.println("Test 3: New Length = " + newLength3);  // Expected: 1
    }
}

