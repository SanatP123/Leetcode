
from typing import Counter


class Solution:
    def minCost(self, nums1: list[int], nums2: list[int]) -> int:
        diff = 0
        n = len(nums1)

        # Count occurrences of each number in both arrays
        c1 = Counter(nums1)
        c2 = Counter(nums2)

        for x in set(nums1 + nums2):
            # Check if it's possible to equalize the arrays
            if (c1[x] + c2[x]) % 2 == 1:
                return -1
           # Calculate the total difference
            diff += abs(c1[x] - c2[x])

        # Each swap can fix 4 differences (2 from each array), so divide by 4
        return diff // 4

sol = Solution()
inputs = [([10,20], [20,10]), ([10,10], [20,20]), ([10,20], [30,40])] # 0, 1, -1
for nums1, nums2 in inputs:
    print(f"Input: nums1 = {nums1}, nums2 = {nums2}")
    print(f"Output: {sol.minCost(nums1, nums2)}\n")