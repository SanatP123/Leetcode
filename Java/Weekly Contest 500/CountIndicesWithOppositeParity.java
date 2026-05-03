

public class CountIndicesWithOppositeParity {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++){
            int score = 0;
            boolean parity = false;
            if (nums[i] % 2 == 0){
                parity = true;
            }
            for (int j = i + 1; j < n; j++){
                if (nums[j] % 2 != 0 && parity){
                    score++;
                }
                else if (nums[j] % 2 == 0 && parity == false){
                    score++;
                }
            }
            answer[i] = score;
        }

        return answer;
        
    }

    public static void main(String[] args) {
        CountIndicesWithOppositeParity sol = new CountIndicesWithOppositeParity();
        int[] nums = {1,2,3,4};
        int[] ans = sol.countOppositeParity(nums);
        for (int i: ans){
            System.out.print(i + " ");
        }
        System.out.println();

        CountIndicesWithOppositeParity sol2 = new CountIndicesWithOppositeParity();
        int[] nums2 = {1};
        int[] ans2 = sol2.countOppositeParity(nums2);
        for (int i: ans2){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
}
