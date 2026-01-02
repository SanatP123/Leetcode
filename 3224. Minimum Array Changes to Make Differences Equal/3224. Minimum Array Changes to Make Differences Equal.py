from typing import List
class Solution:
    def minChanges(self, nums: List[int], k: int) -> int:
        n = len(nums)

        # k+2 is used for index_error safety
        change_range = [0 for _ in range(k+2)]

        for i in range(n//2):
            a = nums[i]
            b = nums[n-i-1]
            cur_diff = abs(a - b)
            max_diff = max(a,b,k-a,k-b)

            change_range[0] += 1
            change_range[cur_diff] -= 1
            change_range[cur_diff + 1]  += 1
            change_range[max_diff + 1] += 1
        
        curr_change, min_change = 0, n
        for i in range(k+1):
            curr_change += change_range[i]
            min_change = min(curr_change, min_change)
        
        return min_change
        
            
s = Solution()

# Adding test cases for the given examples
inputs = [
    ([1, 0, 1, 2, 4, 3], 4),  # Example 1
    ([0, 1, 2, 3, 3, 6, 5, 4], 6)  # Example 2
]

# Running the test cases
for nums, k in inputs:
    print(f"Input: nums = {nums}, k = {k}")
    output = s.minChanges(nums, k)
    print(f"Output: {output}\n")