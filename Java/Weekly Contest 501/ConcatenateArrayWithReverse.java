

public class ConcatenateArrayWithReverse {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        for (int i = 0; i < n; i++){
            ans[i] = nums[i];
            ans[i+n] = nums[n-i-1];
        }
        
        return ans;
    }

    public static void main(String[] args) {
        ConcatenateArrayWithReverse sol = new ConcatenateArrayWithReverse();
        int[] nums = {1,2,3};
        int[] ans = sol.concatWithReverse(nums);
        for (int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }

        ConcatenateArrayWithReverse sol2 = new ConcatenateArrayWithReverse();
        int[] nums2 = {1};
        int[] ans2 = sol2.concatWithReverse(nums2);
        System.out.println();
        for (int i = 0; i < ans2.length; i++){
            System.out.print(ans2[i] + " ");
        }
    }
    
}
