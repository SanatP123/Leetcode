public class MinimumOperationstoTransformArrayintoAlternatingPrime {
    public int minOperations(int[] nums) {

        int operations = 0;

        for (int i = 0; i < nums.length; i++){
            // Current value
            int curr = nums[i];

            // Even index must be prime
            if (i % 2 == 0){
                while (checkPrime(curr) != true){
                    curr += 1;
                    operations += 1;
                    }    
                }
            
            else {
                // Odd index must be non-prime
                while (checkPrime(curr) != false){
                    curr += 1;
                    operations += 1;
                    }
                }
        }
            
        return operations;
        
    }

    // Check if number is prime
    public boolean checkPrime(int num){
            if (num <= 1){
                return false;
            }
            for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
            return true;
        }
    
    
    public static void main(String[] args) {
        MinimumOperationstoTransformArrayintoAlternatingPrime solution = new MinimumOperationstoTransformArrayintoAlternatingPrime();   

        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Test 1: " + solution.minOperations(nums1));

        // Test case 2
        int[] nums2 = {5,6,7,8};
        System.out.println("Test 2: " + solution.minOperations(nums2));
        
        // Test case 3
        int[] nums3 = {4,4};
        System.out.println("Test 3: " + solution.minOperations(nums3));

}

}
