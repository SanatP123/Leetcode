public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while (left < right){
            int mid = (left + right)/2;

            if (nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return nums[left];
        
    }
    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray sol = new FindMinimuminRotatedSortedArray();
        int[] nums = {3,4,5,1,2};
        int ans = sol.findMin(nums);
        System.out.println(ans);

        FindMinimuminRotatedSortedArray sol2 = new FindMinimuminRotatedSortedArray();
        int[] nums2 = {4,5,6,7,0,1,2};
        int ans2 = sol2.findMin(nums2);
        System.out.println(ans2);

        FindMinimuminRotatedSortedArray sol3 = new FindMinimuminRotatedSortedArray();
        int[] nums3 = {11,13,15,17};
        int ans3 = sol3.findMin(nums3);
        System.out.println(ans3);
    }
    
}
