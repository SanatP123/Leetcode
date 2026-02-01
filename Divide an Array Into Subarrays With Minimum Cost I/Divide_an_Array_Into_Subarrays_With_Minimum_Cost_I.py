
from typing import List
class Solution:
    def minimumCost(self, nums: List[int]) -> int:
        ans = nums[0]
        min1 = float("inf")
        min2 = float("inf")

        for i in range(1,len(nums)):
            curr = nums[i]

            if (curr < min1):
                min2 = min1
                min1 = curr
            elif (curr < min2):
                min2 = curr

        return ans + min1 + min2        

# Test cases based on the examples provided
s = Solution()
inputs = [[1,2,3,12],[5,4,3],[10,3,1,1]]
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {s.minimumCost(nums)}\n")
