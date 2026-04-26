import java.util.ArrayList;
import java.util.List;

public class ValidElementsinanArray {
     public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        int[] maxEleLeft = new int[n];
        int[] maxEleRight = new int[n];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if (i == 0 || i == n-1){
                maxEleLeft[i] = nums[i];
            }
            else{
            maxEleLeft[i] = Math.max(maxEleLeft[i-1],nums[i-1]);
            }
        }

        for (int j = n-1; j >= 0; j--){
            if (j == 0 || j == n-1){
                maxEleRight[j] = nums[j];
            }
            else{
            maxEleRight[j] = Math.max(maxEleRight[j+1], nums[j+1]);
            }
        }

        res.add(0,nums[0]);
        
        for (int k = 1; k < n-1; k++){
            if (nums[k] > maxEleLeft[k] || nums[k] > maxEleRight[k]){
                res.add(nums[k]);
            }
        }

        if (n > 1) {
            res.add(nums[n - 1]);
        }

        return res;
        
    }

    public static void main(String[] args) {
        ValidElementsinanArray sol = new ValidElementsinanArray();
        int[] nums = {1,2,4,2,3,2};
        List<Integer> ans = sol.findValidElements(nums);
        System.out.println(ans);

        ValidElementsinanArray sol2 = new ValidElementsinanArray();
        int[] nums2 = {5,5,5,5};
        List<Integer> ans2 = sol2.findValidElements(nums2);
        System.out.println(ans2);

        ValidElementsinanArray sol3 = new ValidElementsinanArray();
        int[] nums3 = {1};
        List<Integer> ans3 = sol3.findValidElements(nums3);
        System.out.println(ans3);
    }
    
}
