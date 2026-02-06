from typing import List
class Solution:
    def minRemoval(self, nums: List[int], k: int) -> int:
        n = len(nums)
        nums.sort()
        left = 0
        max_len = 0

        
        for right in range(n):
            # shrink window from left until balanced
            while nums[left] * k < nums[right]:
                left += 1
            
            max_len = max(max_len, right - left + 1)
        
        # minimum removals = total elements - length of longest balanced subarray
        return n - max_len

s = Solution()
inputs = [([2,1,5], 2), ([1,6,2,9], 3), ([4,6], 2)]
for nums, k in inputs:
    print(f"Input: nums = {nums}, k = {k}")
    print(f"Output: {s.minRemoval(nums, k)}\n")