class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right){
            int mid = (left + right)/2;

            if (nums[mid] == target) return mid;

            if(nums[left] <= nums[mid]){
                // Check if target lies between left and mid
                if (nums[left] <= target && nums[mid] > target){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }

            }
            else{
                // Check if target lies between mid and right
                if (nums[right] >= target && nums[mid] < target){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }

        }

        return -1;

        
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray solution = new SearchinRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int result = solution.search(nums, target);
        System.out.println("Target found at index: " + result);

        SearchinRotatedSortedArray solution2 = new SearchinRotatedSortedArray();
        int[] nums2 = {4,5,6,7,0,1,2};
        int target2 = 3;
        int result2 = solution2.search(nums2, target2);
        System.out.println("Target found at index: " + result2);

        SearchinRotatedSortedArray solution3 = new SearchinRotatedSortedArray();    
        int[] nums3 = {1};
        int target3 = 0;
        int result3 = solution3.search(nums3, target3);
        System.out.println("Target found at index: " + result3);
    }
}