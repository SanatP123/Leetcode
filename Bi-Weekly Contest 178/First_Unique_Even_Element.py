
from collections import Counter


class Solution:
    def firstUniqueEven(self, nums: list[int]) -> int:
        count = Counter(nums)

        for num in nums:
            if num % 2 == 0 and count[num] == 1:
                return num

        return -1

sol = Solution()
inputs = [[3,4,2,5,4,6], [4,4]] # 2, -1
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {sol.firstUniqueEven(nums)}\n")