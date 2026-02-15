from typing import List
from collections import Counter
class Solution:
    def firstUniqueFreq(self, nums: List[int]) -> int:
        count = Counter(nums)
        freq_count = Counter(count.values())  # frequency -> how many numbers have it


        for num in nums:
            if freq_count[count[num]] == 1:
                return num

        return -1 


sol = Solution()
inputs = [[20,10,30,30],[20,20,10,30,30,30],[10,10,20,20]]
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {sol.firstUniqueFreq(nums)}\n")        
        
