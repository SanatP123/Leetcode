from typing import List
class Solution:
    def uniformArray(self, nums1: list[int]) -> bool:
        mini = float("inf")
        odd = False

        # Find the smallest odd number
        for num in nums1:
            if num % 2 == 1:
                odd = True
                mini = min(mini, num)

        if not odd:
            return True

        # Check if any even number is smaller than this odd
        for num in nums1:
            if num % 2 == 0 and mini > num:
                return False

        return True        

sol = Solution()
inputs = [[1,4,7], [2,3], [4,6]]
for nums1 in inputs:
    print(f"Input: nums1 = {nums1}")
    print(f"Output: {sol.uniformArray(nums1)}\n")