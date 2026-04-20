public class TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        int distance = 0;
        int n = colors.length;
        
        // Compare with first house
        for (int j = n-1; j >= 0; j--){
            if (colors[j] != colors[0]){
                distance = j;
                break;
            }
        }

        // Compare with last house
        for (int i = 0; i < n; i++){
            if (colors[i] != colors[n-1]){
                distance = Math.max(distance, n-1-i);
                break;
            }
        }

        return distance;
        
    }

    public static void main(String[] args) {
        TwoFurthestHousesWithDifferentColors solution = new TwoFurthestHousesWithDifferentColors();
        // Test case 1
        int[] colors1 = {1,1,1,6,1,1,1};
        System.out.println("Test 1: " + solution.maxDistance(colors1));  // Expected: 3

        // Test case 2
        int[] colors2 = {1,8,3,8,3};
        System.out.println("Test 2: " + solution.maxDistance(colors2));  // Expected: 4

        // Test case 3
        int[] colors3 = {4,4,4,11,4,4,11,4,4,4,4,4};
        System.out.println("Test 3: " + solution.maxDistance(colors3));  // Expected: 8

        int[] colors4 = {0,1};
        System.out.println("Test 4: " + solution.maxDistance(colors4));  // Expected: 1
    }
    
}
