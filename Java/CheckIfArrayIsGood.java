public class CheckIfArrayIsGood {
    public boolean isGood(int[] nums) {
        int n = nums.length;

        // Frequency array to count occurrences
        int[] frequencies = new int[n];

        // Invalid if number is outside range [1, n-1]
        for (int num : nums){
            if (num < 1 || num > n-1){
                return false;
            }

            frequencies[num]++;
        }

        // Numbers from 1 to n-2 must appear exactly once
        for (int i = 1; i < n-1; i++){
            if (frequencies[i] != 1){
                return false;
            }
        }

        // Number (n-1) must appear exactly twice
        if (frequencies[n-1] != 2){
            return false;
        }

        return true;
        
    }

    public static void main(String[] args) {
        CheckIfArrayIsGood sol = new CheckIfArrayIsGood();
        int[] nums = {2,1,3};
        boolean ans = sol.isGood(nums);
        System.out.println(ans);

        CheckIfArrayIsGood sol2 = new CheckIfArrayIsGood();
        int[] nums2 = {1,3,3,2};
        boolean ans2 = sol2.isGood(nums2);
        System.out.println(ans2);

        CheckIfArrayIsGood sol3 = new CheckIfArrayIsGood();
        int[] nums3 = {1,1};
        boolean ans3 = sol3.isGood(nums3);
        System.out.println(ans3);

        CheckIfArrayIsGood sol4 = new CheckIfArrayIsGood();
        int[] nums4 = {3, 4, 4, 1, 2, 1};
        boolean ans4 = sol4.isGood(nums4);
        System.out.println(ans4);

        CheckIfArrayIsGood sol5 = new CheckIfArrayIsGood();
        int[] nums5 = {9, 9};
        boolean ans5 = sol5.isGood(nums5);
        System.out.println(ans5);

        CheckIfArrayIsGood sol6 = new CheckIfArrayIsGood();
        int[] nums6 = {2,3,5,5,4};
        boolean ans6 = sol6.isGood(nums6);
        System.out.println(ans6);

    }
    
}
