import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SumofDistances {
    public long[] distance(int[] nums) {
        
        int n = nums.length;
        long[] arr = new long[n]; 
        HashMap<Integer,List<Integer>> indexes = new HashMap<>();

        // group indices by value
        for (int i = 0; i < n; i++){
            indexes.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i);
        }

        for (List<Integer> list : indexes.values()){
            int size = list.size();

            // prefix[i] = sum of first i indices
            long[] prefix = new long[size+1];

            for (int i = 0; i < size; i++){
                prefix[i+1] = prefix[i] + list.get(i);
            }


            for (int k = 0; k < size; k++){
                int idx = list.get(k);

                // distance to all left indices
                long left = (long)k * idx - prefix[k];

                // distance to all right indices
                long right = (prefix[size] - prefix[k + 1]) - (long) (size - k - 1) * idx;

                arr[idx] = left + right;
            }

        }

        return arr;

        
    }

    public static void main(String[] args) {
        SumofDistances sol = new SumofDistances();
        int[] nums = {1,3,1,1,2};
        long[] ans = sol.distance(nums);
        System.out.println(Arrays.toString(ans));

        
        SumofDistances sol2 = new SumofDistances();
        int[] nums2 = {0,5,3};
        long[] ans2 = sol2.distance(nums2);
        System.out.println(Arrays.toString(ans2));
        

        SumofDistances sol3 = new SumofDistances();
        int[] nums3 = {4,4,4,4};
        long[] ans3 = sol3.distance(nums3);
        System.out.println(Arrays.toString(ans3));
    }
    
}
