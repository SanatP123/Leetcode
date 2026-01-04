
from typing import List

from math import sqrt

class Solution:
    def sumFourDivisors(self, nums: List[int]) -> int:
        
        def check_four_divisors(n):
            divisor = []

            for i in range(1,int(sqrt(n)) + 1):
                if n % i == 0:
                    divisor.append(i)
                
                    if i != n//i:
                        divisor.append(n//i)
            
            return (len(divisor) == 4, divisor)

        curr_sum = 0
        for i in range(len(nums)):
                if check_four_divisors(nums[i])[0]:
                    curr_sum += sum(check_four_divisors(nums[i])[1])
            
        return curr_sum



s = Solution()

# Updated test cases based on the examples provided

inputs = [[21,4,7],[21,21],[1,2,3,4,5],[21,33,4,7]]

# Running the test cases

for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {s.sumFourDivisors(nums)}\n")