
from math import gcd

class Solution:
    def gcdSum(self, nums: list[int]) -> int:
        prefixGcd = []
        curr_max = nums[0]

        for i in range(len(nums)):
            # Update the current maximum and calculate the GCD with it
            curr_max = max(curr_max, nums[i])
            curr_gcd = gcd(nums[i], curr_max)
            prefixGcd.append(curr_gcd)
        
        # Sort the prefix GCDs and use two pointers to calculate the sum of GCDs of pairs
        prefixGcd.sort()
        l = 0
        r = len(prefixGcd) - 1
        sums = 0
        
        while l < r:
            smallest = prefixGcd[l]
            largest = prefixGcd[r]
            # Add the GCD of the smallest and largest to the sum
            sums += gcd(smallest,largest)
            l += 1
            r -= 1

        return sums


sol = Solution()
inputs = [[2,6,4], [3,6,2,8]] # 2, 5
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {sol.gcdSum(nums)}\n")