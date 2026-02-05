from typing import List

class Solution:
    def constructTransformedArray(self, nums: List[int]) -> List[int]:
        result = []
        n = len(nums)
        
        for i in range(n):
            # Use circular indexing works for both left, right and zero operations
            j = (i + nums[i]) % n
            result.append(nums[j])
        
        return result

s = Solution()
inputs = [[0,2,1,5,3], [0,1,2], [1,2,3,4,5]]
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {s.constructTransformedArray(nums)}\n")
