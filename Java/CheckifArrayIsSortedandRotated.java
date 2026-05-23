public class CheckifArrayIsSortedandRotated {
    public boolean check(int[] nums) {
        int n = nums.length;
        int orderBreak = 0;
        for (int i = 0; i < n; i++){
            if (nums[i] > nums[(i+1)%n]){
                orderBreak++;
                if (orderBreak > 1){
                    return false;
                }
            }
        }

        return true;
        
    }

    public static void main(String[] args) {
        CheckifArrayIsSortedandRotated solution = new CheckifArrayIsSortedandRotated();
        int[] nums = {3,4,5,1,2};
        boolean result = solution.check(nums);
        System.out.println("Is the array sorted and rotated? " + result);

        CheckifArrayIsSortedandRotated solution2 = new CheckifArrayIsSortedandRotated();
        int[] nums2 = {2,1,3,4};
        boolean result2 = solution2.check(nums2);
        System.out.println("Is the array sorted and rotated? " + result2);

        CheckifArrayIsSortedandRotated solution3 = new CheckifArrayIsSortedandRotated();    
        int[] nums3 = {1,2,3};
        boolean result3 = solution3.check(nums3);
        System.out.println("Is the array sorted and rotated? " + result3);
    }
    
}
