from typing import List

class Solution:
    def minAbsoluteDifference(self, nums: list[int]) -> int:
        min_abs = float("inf")
        
        # Store most recent index of 1 and 2
        cur_i = None
        cur_j = None

        for i in range(len(nums)):
            # Update latest 1
            if nums[i] == 1:
                cur_i = i

            # Update latest 2
            if nums[i] == 2:
                cur_j = i
            if cur_i is not None and cur_j is not None:
                min_abs = min(min_abs,abs(cur_j - cur_i))
        
        # If no valid pair found, return -1
        return -1 if min_abs == float("inf") else min_abs
            
sol = Solution()
inputs = [[1,0,0,2,0,1], [1,0,1,0]]
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {sol.minAbsoluteDifference(nums)}\n")