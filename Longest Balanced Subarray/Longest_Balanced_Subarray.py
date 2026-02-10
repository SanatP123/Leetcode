
from typing import List

class Solution:
    def longestBalanced(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(n):
            # If the remaining elements cannot beat the current answer, stop early
            if i >= n - ans: break
            # Track distinct even and odd numbers in the current subarray
            odd_even = {0:set(),1:set()}

            for j,num in enumerate(nums[i:]):

                odd_even[num % 2].add(num)
                # Balanced subarray
                if len(odd_even[0]) == len(odd_even[1]):
                    ans = max(ans,j+1)
            
        return ans

sol = Solution()
inputs = [[2,5,4,3],[3,2,2,5,4],[1,2,3,2]]
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {sol.longestBalanced(nums)}\n")


