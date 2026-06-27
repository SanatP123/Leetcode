import java.util.HashMap;

public class FindtheMaximumNumberofElementsinSubset {
    
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency of each number
        for (int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        int ans = 1;

        for (int key : freq.keySet()){
            // For 1, only an odd count can form a valid sequence
            if (key == 1){
                int val = freq.get(key);
                int odd = 1 - val % 2;
                ans = Math.max(ans, val - odd);
                continue;
            }

            
            int curr = 0;

            // Need at least two copies to place on both sides
            if (freq.get(key) >= 2){
                int next = key * key;
                curr = 1;
                int time = 0;

                
                // Keep extending while the next value appears at least twice
                while (freq.getOrDefault(next, 0) >= 2) {
                    curr++;
                    time++;
                    next = next * next;
                }

                // Use one occurrence as the middle element if available
                if (freq.getOrDefault(next, 0) == 1){
                    curr++;
                    time++;
                }

            ans = Math.max(ans,curr + time);
        }
    }

        return ans;
    }

    public static void main(String[] args) {
        FindtheMaximumNumberofElementsinSubset solution = new FindtheMaximumNumberofElementsinSubset();
        int[] nums = {5,4,1,2,2};
        int result = solution.maximumLength(nums);
        System.out.println("Maximum length of subset: " + result);

        FindtheMaximumNumberofElementsinSubset solution2 = new FindtheMaximumNumberofElementsinSubset();
        int[] nums2 = {1,3,2,4};
        int result2 = solution2.maximumLength(nums2);
        System.out.println("Maximum length of subset: " + result2);
    }
    
}
