import java.util.Arrays;

public class MaximumElementAfterDecreasingandRearranging {
    
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        // Sort the array
        Arrays.sort(arr);

        // Value of first element must be 1
        arr[0] = 1;

        // Track the current maximum value
        int currentMax = 1;

        for (int i = 1; i < arr.length; i++){

            // Since the array is sorted, the current element can be at most one greater than the previous element to satisfy: abs(arr[i] - arr[i - 1]) <= 1
            arr[i] = Math.min(arr[i], arr[i-1] + 1);
            currentMax = Math.max(currentMax, arr[i]);
        }

        return currentMax;
        
    }

    public static void main(String[] args) {
        MaximumElementAfterDecreasingandRearranging solution = new MaximumElementAfterDecreasingandRearranging();
        int[] arr = {2, 2, 1, 2, 1};
        int result = solution.maximumElementAfterDecrementingAndRearranging(arr);
        System.out.println("Maximum element after rearranging: " + result);

        int[] arr2 = {100, 1, 1000};
        int result2 = solution.maximumElementAfterDecrementingAndRearranging(arr2);
        System.out.println("Maximum element after rearranging: " + result2);

        int[] arr3 = {1, 2, 3, 4, 5};
        int result3 = solution.maximumElementAfterDecrementingAndRearranging(arr3);
        System.out.println("Maximum element after rearranging: " + result3);
    }

    
}
