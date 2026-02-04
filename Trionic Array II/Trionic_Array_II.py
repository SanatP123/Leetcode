
from typing import List

class Solution:
    def maxSumTrionic(self, nums: List[int]) -> int:
        n = len(nums)

        dp = [[float('-inf')] * 4 for _ in range(n)]

        res = float('-inf')

         # Base case: every element alone can start a sequence
        for i in range(n):
            dp[i][0] = nums[i]

        for i in range(1,n):
            # Increasing step (first or third phase)
            if nums[i-1] < nums[i]:
                dp[i][1] = max(dp[i-1][0] + nums[i], dp[i-1][1] + nums[i])
                dp[i][3] = max(dp[i-1][3] + nums[i], dp[i-1][2] + nums[i])

                res = max(res, dp[i][3])
            
            # Decreasing step
            elif nums[i-1] > nums[i]:
                dp[i][2] = max(dp[i-1][2] + nums[i], dp[i-1][1] + nums[i])
        
        return res


s = Solution()
inputs = [[0,-2,-1,-3,0,2,-1], [1,4,2,7], [3,1,2,1,3,4,3]]
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {s.maxSumTrionic(nums)}\n")
