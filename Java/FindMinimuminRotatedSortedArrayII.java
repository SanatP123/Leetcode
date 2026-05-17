public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int n = nums.length;

        // // Handle Duplicates
        // int[] newNums = new int[n];
        // HashSet<Integer> seen = new HashSet<>();
        // int idx = 0;

        // for (int i = 0; i < n; i++){
        //     if (seen.contains(nums[i])){
        //         continue;
        //     }
        //     else{
        //         seen.add(nums[i]);
        //         newNums[idx++] = nums[i];

        //     }
        // }

        // int length = idx;
        int left = 0;
        // int right = idx-1;
        int right = n - 1;

        while (left < right){
            int mid = (left + right)/2;

            if (nums[mid] > nums[right]){
                left = mid + 1;
            }
            else if (nums[mid] < nums[right]){
                right = mid;
            }
            else{
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimuminRotatedSortedArrayII sol = new FindMinimuminRotatedSortedArrayII();
        int[] nums = {2,2,2,0,1};
        int ans = sol.findMin(nums);
        System.out.println(ans);

        FindMinimuminRotatedSortedArrayII sol2 = new FindMinimuminRotatedSortedArrayII();
        int[] nums2 = {1,3,5};
        int ans2 = sol2.findMin(nums2);
        System.out.println(ans2);

        FindMinimuminRotatedSortedArrayII sol3 = new FindMinimuminRotatedSortedArrayII();
        int[] nums3 = {10,1,10,10,10};
        int ans3 = sol3.findMin(nums3);
        System.out.println(ans3);
    }
    
}
