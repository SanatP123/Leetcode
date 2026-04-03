from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        left = 0
        right = n - 1
        
        while left < right:
            mid = (left + right)//2

            # Min is in left half (including mid)
            if nums[mid] < nums[right]:
                right = mid
            
            # Min is in right half
            elif nums[mid] > nums[right]:
                left = mid + 1
            # Duplicates → shrink search space
            else:
                right -= 1
                
        return nums[left]


sol = Solution()
inputs = [[1,3,5], [2,2,2,0,1], [1,1,1,0,1]]
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {sol.findMin(nums)}\n")