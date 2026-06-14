import java.util.HashMap;
public class FrequencyBalanceSubarray {
    
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 1;

        // Try every starting index
        for (int i = 0; i < n; i++){
            HashMap<Integer,Integer> freq = new HashMap<>();
            HashMap<Integer,Integer> freqCount = new HashMap<>();
            int maxfreq = 0;

            // Extend subarray nums[i..j]
            for (int j = i; j < n; j++){
                int oldfreq = freq.getOrDefault(nums[j], 0);

                // Remove old frequency count
                if (oldfreq > 0){
                    freqCount.put(oldfreq, freqCount.get(oldfreq) - 1);
                    if (freqCount.get(oldfreq) == 0) {
                        freqCount.remove(oldfreq);
                    }
                }

                // Add new frequency count
                int newfreq = oldfreq + 1;
                freq.put(nums[j], newfreq);
                freqCount.put(newfreq, freqCount.getOrDefault(newfreq, 0) + 1);

                maxfreq = Math.max(maxfreq, newfreq);

                 // Check if current subarray is balanced
                if (isBalanced(freq.size(), freqCount,maxfreq)){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    public boolean isBalanced(int size, HashMap<Integer, Integer> freqCount, int maxfreq){

          // One distinct value is always balanced
        if (size == 1) return true;

        // Need both f and 2f, so maxfreq must be even
        if (maxfreq % 2 != 0){
            return false;
        }

        int high = freqCount.getOrDefault(maxfreq,0);
        int low = freqCount.getOrDefault(maxfreq/2,0);

        // Both frequencies must appear
        if (high == 0 || low == 0){
            return false;
        }

        // All distinct values must have frequency maxfreq or maxfreq/2
        return high + low == size;
    }

    public static void main(String[] args) {
        FrequencyBalanceSubarray solution = new FrequencyBalanceSubarray();
        int[] nums = {1,2,2,1,2,3,3,3};
        int result = solution.getLength(nums);
        System.out.println(result); // Output: 6

        FrequencyBalanceSubarray solution2 = new FrequencyBalanceSubarray();
        int[] nums2 = {5,5,5,5};
        int result2 = solution2.getLength(nums2);
        System.out.println(result2); // Output: 6

        FrequencyBalanceSubarray solution3 = new FrequencyBalanceSubarray();
        int[] nums3 = {1,2,3,4};
        int result3 = solution3.getLength(nums3);
        System.out.println(result3); // Output: 4
    }
}
