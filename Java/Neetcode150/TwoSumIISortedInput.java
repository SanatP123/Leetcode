
    
    
    public class TwoSumIISortedInput {
        public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;

        while (left < right){
            int sum = numbers[left] + numbers[right];
            if (sum > target){
                right--;
            }
            else if (sum < target){
                left++;
            }
            else{
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};        
    }

    public static void main(String args[]){
        TwoSumIISortedInput sol = new TwoSumIISortedInput();
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] ans = sol.twoSum(numbers, target);
        for (int i : ans){
            System.out.print(i + " ");
        }
        System.out.println();

        TwoSumIISortedInput sol2 = new TwoSumIISortedInput();
        int[] numbers2 = {2,3,4};
        int target2 = 6;
        int[] ans2 = sol2.twoSum(numbers2, target2);
        for (int i : ans2){
            System.out.print(i + " ");
        }
        System.out.println();

        TwoSumIISortedInput sol3 = new TwoSumIISortedInput();
        int[] numbers3 = {-1,0};
        int target3 = -1;
        int[] ans3 = sol3.twoSum(numbers3, target3);
        for (int i : ans3){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    
}