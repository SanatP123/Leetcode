from typing import List
from collections import defaultdict

class Solution:
    def minLength(self, nums: List[int], k: int) -> int:
        min_length = float('inf')

        left = 0
        n = len(nums)
        freq_map = defaultdict(int)
        curr_sum = 0
        for right in range(len(nums)):
            freq_map[nums[right]] += 1
            if freq_map[nums[right]] == 1:
                curr_sum += nums[right]
                
            while curr_sum >= k:
                min_length = min(min_length, right - left + 1)

                freq_map[nums[left]] -= 1
                if freq_map[nums[left]] == 0:
                    curr_sum -= nums[left]

                left += 1
            

        return min_length if min_length != float('inf') else -1

# Test cases based on the examples provided
inputs = [([2, 2, 3, 1], 4), ([3, 2, 3, 4], 5), ([5, 5, 4], 5)]

# Running the test cases
s = Solution()
for nums, k in inputs:
    print(f"Input: nums = {nums}, k = {k}")
    print(f"Output: {s.minLength(nums, k)}\n")



