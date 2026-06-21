public class ValidSubarraysWithMatchingSumDigitsI {
    public int countValidSubarrays(int[] nums, int x) {

        int res = 0;
        for (int i = 0; i < nums.length; i++){
            long sum = 0;
            for (int j = i; j < nums.length; j++){
                sum += nums[j];
                if (checkValidity(sum,x)){
                    res += 1;
                }

            }


        }
        return res;
    }

    public boolean checkValidity(long sum, int x){
        int last = (int) (sum % 10);
        long temp =  sum;
        while (temp >= 10){
            temp /= 10;
        }
        int first = (int) temp;

        return first == x && last == x;
    }

    public static void main(String[] args) {
        ValidSubarraysWithMatchingSumDigitsI solution = new ValidSubarraysWithMatchingSumDigitsI();
        int[] nums = {1,100,1};
        int x = 1;
        int result = solution.countValidSubarrays(nums, x);
        System.out.println(result); // Output: 4

        ValidSubarraysWithMatchingSumDigitsI solution2 = new ValidSubarraysWithMatchingSumDigitsI();
        int[] nums2 = {1};
        int x2 = 2;
        int result2 = solution2.countValidSubarrays(nums2, x2);
        System.out.println(result2); // Output: 0

        ValidSubarraysWithMatchingSumDigitsI solution3 = new ValidSubarraysWithMatchingSumDigitsI();
        int[] nums3 = {5,5,5};
        int x3 = 5;
        int result3 = solution3.countValidSubarrays(nums3, x3);
        System.out.println(result3); // Output: 6
    }
    
}
