import java.util.ArrayList;
import java.util.List;

public class PartitionArrayAccordingtoGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {

        // Tracks smaller elements
        List<Integer> smallElements = new ArrayList<>();

        // Tracks greater elements
        List<Integer> greatElements = new ArrayList<>();

        // Track number of Pivot elements
        int numberofPivot = 0;

        // Populate all the elements in specific categories
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < pivot){
                smallElements.add(nums[i]);
            }
            else if(nums[i] > pivot){
                greatElements.add(nums[i]);
            }
            else{
                numberofPivot += 1;
            }
        }

        // Track index to rearrange elements
        int index = 0;


        // Add smaller elements
        for (int num : smallElements){
            nums[index++] = num;
            
        }

        
        // Add pivot elements
        while (numberofPivot > 0){
            nums[index++] = pivot;
            numberofPivot -= 1;
        }

        // Add greater elements
        for (int num : greatElements){
            nums[index++] = num;
        }

        return nums;
       
        
    }

    public static void main(String[] args) {
        PartitionArrayAccordingtoGivenPivot solution = new PartitionArrayAccordingtoGivenPivot();
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;
        int[] result = solution.pivotArray(nums, pivot);
        System.out.print("Partitioned array: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        PartitionArrayAccordingtoGivenPivot solution2 = new PartitionArrayAccordingtoGivenPivot();
        int[] nums2 = {-3, 4, 3, 2};
        int pivot2 = 2;
        int[] result2 = solution2.pivotArray(nums2, pivot2);
        System.out.print("Partitioned array: ");
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println();
    
    }
    
}
