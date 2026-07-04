import java.util.HashMap;

public class UniqueMiddleElement {
    
    public boolean isMiddleElementUnique(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < nums.length; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        int index = (int)Math.floor(n/2);
        return count.get(nums[index]) == 1;
        
        
    }

    public static void main(String[] args) {
        UniqueMiddleElement solution = new UniqueMiddleElement();
        int[] nums1 = {1, 2, 3};
        System.out.println("Is middle element unique? " + solution.isMiddleElementUnique(nums1)); // Output: true

        int[] nums2 = {1, 2, 2};
        System.out.println("Is middle element unique? " + solution.isMiddleElementUnique(nums2)); // Output: false

    
}
}
