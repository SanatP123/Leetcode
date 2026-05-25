package BiweeklyContest183;
public class MinimumSwapstoMoveZerostoEnd {
     public int minimumSwaps(int[] nums) {
        int n = nums.length;
        
        int count = 0;

        for(int num : nums){
            if (num == 0){
                count++;
            }
        }

        int swaps = 0;
        for(int i = 0; i < n - count; i++){
            if (nums[i] == 0){
                swaps++;
            }
        }

        return swaps;
        
        
    }

    public static void main(String[] args) {
        MinimumSwapstoMoveZerostoEnd solution = new MinimumSwapstoMoveZerostoEnd();
        int[] nums = {0,1,0,3,12};
        int result = solution.minimumSwaps(nums);
        System.out.println("Minimum swaps to move zeros to end: " + result);

        MinimumSwapstoMoveZerostoEnd solution2 = new MinimumSwapstoMoveZerostoEnd();
        int[] nums2 = {0,1,0,2};
        int result2 = solution2.minimumSwaps(nums2);
        System.out.println("Minimum swaps to move zeros to end: " + result2);

        MinimumSwapstoMoveZerostoEnd solution3 = new MinimumSwapstoMoveZerostoEnd();    
        int[] nums3 = {1,2,0};
        int result3 = solution3.minimumSwaps(nums3);
        System.out.println("Minimum swaps to move zeros to end: " + result3);

        MinimumSwapstoMoveZerostoEnd solution4 = new MinimumSwapstoMoveZerostoEnd();    
        int[] nums4 = {0,0};
        int result4 = solution4.minimumSwaps(nums4);
        System.out.println("Minimum swaps to move zeros to end: " + result4);

    }
    
}
