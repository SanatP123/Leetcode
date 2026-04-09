class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer for last valid element in nums1
        int i = m - 1;
        
        // Pointer for last element in nums2
        int j = n - 1;
        
        // Pointer for last position in nums1 (total size m + n)
        int k = m + n - 1;

        // Compare the largest elements from both arrays
        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }
            else{
                nums1[k--] = nums2[j--];
            }
        }
        
        // If nums2 still has elements left
        while (j >= 0){
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();

        // Test case 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.print("Test 1: ");
        printArray(nums1);  // Expected: [1, 2, 2, 3, 5, 6]

        // Test case 2
        int[] nums1_2 = {1};
        int[] nums2_2 = {};
        solution.merge(nums1_2, 1, nums2_2, 0);
        System.out.print("Test 2: ");
        printArray(nums1_2);  // Expected: [1]

        // Test case 3
        int[] nums1_3 = {0};
        int[] nums2_3 = {1};
        solution.merge(nums1_3, 0, nums2_3, 1);
        System.out.print("Test 3: ");
        printArray(nums1_3);  // Expected: [1]
    }

    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

