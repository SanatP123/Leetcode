

public class CompareSumsofBitonicParts {
    public int compareBitonicSums(int[] nums) {
        int n = nums.length;
        long[] prefix_sum = new long[n];
        long[] suffix_sum = new long[n];
        prefix_sum[0] = nums[0];
        suffix_sum[n-1] = nums[n-1];
        int peak = 0;
        int peak_value = 0;

        for (int i = 1; i < n; i++){
            prefix_sum[i] = prefix_sum[i-1] + nums[i];
            if (nums[i] > peak_value){
                peak_value = nums[i];
                peak = i;
            }
        }

        for (int j = n-2; j >= 0; j--){
            suffix_sum[j] = suffix_sum[j+1] + nums[j];
        }

        if (prefix_sum[peak] > suffix_sum[peak]){
            return 0;
        }
        else if (prefix_sum[peak] < suffix_sum[peak]){
            return 1;
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args) {
        CompareSumsofBitonicParts sol = new CompareSumsofBitonicParts();
        int[] nums = {1, 3, 2, 1};
        int ans = sol.compareBitonicSums(nums);
        System.out.println(ans);

        CompareSumsofBitonicParts sol2 = new CompareSumsofBitonicParts();
        int[] nums2 = {2,4,5,2};
        int ans2 = sol2.compareBitonicSums(nums2);
        System.out.println(ans2);

        CompareSumsofBitonicParts sol3 = new CompareSumsofBitonicParts();
        int[] nums3 = {1,2,4,3};
        int ans3 = sol3.compareBitonicSums(nums3);
        System.out.println(ans3);
    }
    
}
