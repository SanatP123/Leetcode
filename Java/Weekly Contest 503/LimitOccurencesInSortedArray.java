import java.util.Arrays;
public class LimitOccurencesInSortedArray {
   
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;

        if (k == 0){
            return new int[] {};
        }

        int current = 0; // write pointer
        int count = 0; // occurrences of current number

        for (int i = 0; i < n; i++){
             // New number -> reset count, same number -> increment
            if (i == 0 || nums[i] != nums[i-1]){
                count = 1;
            }
            else{
                count++;
            }

            // Keep at most k occurrences
            if (count <= k){
                nums[current] = nums[i];
                current++;
            }

        }

        // Return only the valid prefix
        return Arrays.copyOf(nums,current);
        
    }

    public static void main(String[] args) {
        LimitOccurencesInSortedArray solution = new LimitOccurencesInSortedArray();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = solution.limitOccurrences(nums, k);
        System.out.println("Array after limiting occurrences: " + Arrays.toString(result));

        LimitOccurencesInSortedArray solution2 = new LimitOccurencesInSortedArray();
        int[] nums2 = {1,2,3};
        int k2 = 1;
        int[] result2 = solution2.limitOccurrences(nums2, k2);
        System.out.println("Array after limiting occurrences: " + Arrays.toString(result2));

        LimitOccurencesInSortedArray solution3 = new LimitOccurencesInSortedArray();    
        int[] nums3 = {1,1,1,1};
        int k3 = 3;
        int[] result3 = solution3.limitOccurrences(nums3, k3);
        System.out.println("Array after limiting occurrences: " + Arrays.toString(result3));
    }
}
    
