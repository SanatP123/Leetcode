from typing import List
class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        max_pair_sum = 0
        # Sort the list so we can pair smallest with largest
        nums.sort()
        n = len(nums)

        for i in range(n//2):
            # Pair the i-th smallest number with the i-th largest number
            max_pair_sum = max(max_pair_sum, nums[i] + nums[n-i-1])
        
        return max_pair_sum

s = Solution()
print(s.minPairSum([3,5,2,3]))  # Output: 7
print(s.minPairSum([3,5,4,2,4,6]))  # Output: 8
