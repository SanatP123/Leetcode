
from typing import List
from math import inf

class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        n = len(nums1)
        m = len(nums2)

        DP = [[float(-inf)] * (m+1) for _ in range(n+1)]

        for i in range(n-1,-1,-1):
            for j in range(m-1,-1,-1):

                take = nums1[i] * nums2[j] + max(0, DP[i+1][j+1])

                skip1 = DP[i+1][j]

                skip2 = DP[i][j+1]

                DP[i][j] = max(take,skip1,skip2)
            
        
        return DP[0][0]


sol = Solution()

inputs = [
    ([2,1,-2,5], [3,0,-6]),
    ([3,-2], [2,-6,7]),
    ([-1,-1], [1,1])
]

for nums1, nums2 in inputs:
    print(f"Input: nums1 = {nums1}, nums2 = {nums2} => Output: {sol.maxDotProduct(nums1, nums2)}")  


