public class CountSubarraysWithMajorityElementII {

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        // Convert array:
        // target     -> +1
        // non-target -> -1
        // Now, a subarray has target as majority iff its sum > 0
        for (int i = 0; i < n; i++){
            if (nums[i] == target){
                nums[i] = 1;
            }
            else{
                nums[i] = -1;
            }
        }

        int[] presum = new int[n];
        presum[0] = nums[0];

         // Build prefix sums on transformed array
        for (int i = 1; i < n; i++){
            presum[i] = presum[i-1] + nums[i];
        }

        // Total number of valid subarrays
        long cnt = 0;
        // Number of valid subarrays ending at current index
        long valid = 0;

        // Prefix sums can range from -n to +n, so shift them to [0, 2n]
        int shift = n;

        // Previous prefix sum processed
        int lastSum = 0;

        // freq[x] = number of times prefix sum (x - shift) has appeared
        int[] freq = new int[2 * n + 1];

        freq[shift] = 1;

        for (int i = 0; i < n; i++){
            if (presum[i] > lastSum){
                // If current prefix increased, all previous prefixes equal to
                // lastSum now become smaller than current prefix and hence valid.
                valid += freq[lastSum + shift];
            }
            else{
                // If current prefix decreased, prefixes equal to current prefix
                // are no longer smaller and must be removed.
                valid -= freq[presum[i] + shift];
            }

            // Add all valid subarrays ending at index i
            cnt += valid;
            // Record current prefix sum
            freq[presum[i] + shift]++;
            // Update previous prefix sum
            lastSum = presum[i];
        }

        return cnt;



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
