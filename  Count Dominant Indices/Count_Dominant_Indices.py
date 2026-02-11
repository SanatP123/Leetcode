from typing import List
class Solution:
    def dominantIndices(self, nums: List[int]) -> int:
        
        n = len(nums)
        total = sum(nums)
        prefix_sum = 0
        suffix_sum = 0
        count = 0
        
        for i in range(n-1):
            prefix_sum += nums[i]

            suffix_sum = total - prefix_sum

            if nums[i] * (n-i-1) > suffix_sum:
                count += 1
        
        return count



            

sol = Solution()
inputs = [[5,4,3],[4,1,2],[1,1,1,1]]
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {sol.dominantIndices(nums)}\n")