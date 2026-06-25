public class CountSubarraysWithMajorityElementI {
    public int countMajoritySubarrays(int[] nums, int target) {
        int res = 0;

        // Try every starting index
        for (int i = 0; i < nums.length; i++){
            int count = 0;
            // Extend subarray nums[i..j]
            for (int j = i; j < nums.length; j++){
                if (nums[j] == target){
                    count++;
                }
                // target appears strictly more than half
                if ((2 * count) > j - i + 1){
                    res += 1;
                }
            }
        }

        return res;
        
    }

    public static void main(String[] args) {
        CountSubarraysWithMajorityElementI solution = new CountSubarraysWithMajorityElementI();
        int[] nums = {1,2,2,3};
        int target = 2;
        int result = solution.countMajoritySubarrays(nums, target);
        System.out.println(result); // Output: 5

        CountSubarraysWithMajorityElementI solution2 = new CountSubarraysWithMajorityElementI();
        int[] nums2 = {1,1,1,1};
        int target2 = 1;
        int result2 = solution2.countMajoritySubarrays(nums2, target2);
        System.out.println(result2); // Output: 10

        CountSubarraysWithMajorityElementI solution3 = new CountSubarraysWithMajorityElementI();
        int[] nums3 = {1,2,3};
        int target3 = 4;
        int result3 = solution3.countMajoritySubarrays(nums3, target3);
        System.out.println(result3); // Output: 0
    }
    
}
