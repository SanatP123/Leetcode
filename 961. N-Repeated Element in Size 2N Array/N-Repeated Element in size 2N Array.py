from typing import List
from collections import Counter
class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        dic = {}
        for i in nums:
            if i in dic:
                return i
            dic[i] = 1
    
    # def repeatedNTimes(self, nums: List[int]) -> int:
    #     m = len(nums)
    #     n = m // 2
    #     count = Counter(nums)
    #     for i,j in count.items():
    #         if j == n:
    #             return i

sol = Solution()
inputs = [
    [1, 2, 3, 3],
    [2, 1, 2, 5, 3, 2],
    [5, 1, 5, 2, 5, 3, 5, 4]
]

for test_input in inputs:
    print(f"Input: {test_input} => Output: {sol.repeatedNTimes(test_input)}")