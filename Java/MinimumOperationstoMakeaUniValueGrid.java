import java.util.ArrayList;
import java.util.Collections;

public class MinimumOperationstoMakeaUniValueGrid {
    public int minOperations(int[][] grid, int x) {

        // Create a list to store all the numbers from the grid
        ArrayList<Integer> nums = new ArrayList<>();

        // Flatten the grid into nums
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                nums.add(grid[row][col]);
            }
        }

         // Sort nums to easily find the median
        Collections.sort(nums);

        int length = nums.size();
        int median = nums.get(length / 2);

        int result = 0;

        for (int num : nums){

            // If the remainder when divided by x is different, return -1
            if (num % x != median % x){
                return -1;
            }

            // Add the number of operations required to make the current number equal to median
            result += Math.abs(median - num) / x;
        }

        return result;


        
    }

    public static void main(String[] args) {
        MinimumOperationstoMakeaUniValueGrid sol = new MinimumOperationstoMakeaUniValueGrid();
        int[][] grid = {{2,4},{6,8}};
        int x = 2;
        int ans = sol.minOperations(grid, x);
        System.out.println(ans);

        MinimumOperationstoMakeaUniValueGrid sol2 = new MinimumOperationstoMakeaUniValueGrid();
        int[][] grid2 = {{1,5},{2,3}};
        int x2 = 1;
        int ans2 = sol2.minOperations(grid2, x2);
        System.out.println(ans2);

        MinimumOperationstoMakeaUniValueGrid sol3 = new MinimumOperationstoMakeaUniValueGrid();
        int[][] grid3 = {{1,2},{3,4}};
        int x3 = 2;
        int ans3 = sol3.minOperations(grid3, x3);
        System.out.println(ans3);
    }
    
}
