from typing import List
class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        nums.sort()
        # Highest and Lowest k scores would be same
        if k == 1:
            return 0

        min_diff = float("inf")
        
        # Iterate in a window of k, as the array is sorted, the kth element would be highest and ith element lowest
        for i in range(0,len(nums) - k + 1):
            min_diff = min(min_diff, nums[i+k-1] - nums[i])
            
        return min_diff


sol = Solution()
nums = [90, 70, 80, 50, 60]
k = 3
result = sol.minimumDifference(nums, k)
print(f"The minimum difference between highest and lowest of {k} scores in the array {nums} is: {result}")