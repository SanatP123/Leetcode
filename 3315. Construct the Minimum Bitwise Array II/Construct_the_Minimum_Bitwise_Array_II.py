
from typing import List


class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        ans = []

        for num in nums:
            # 2 is the only prime and it's not possible to satisfy the condition
            if num == 2:
                ans.append(-1)
            
            else:
                # Make a copy of num so we don't destroy the original value
                temp = num
                 # This will count how many consecutive '1's
                # appear at the right end of num's binary form
                count = 0

                # Shift right until we hit a '0'
                while (temp & 1) == 1:
                    count += 1
                    temp >>= 1
                
                # Remove the highest bit among the trailing 1s
                ans.append(num - 2**(count-1))
                
        return ans

sol = Solution()
nums = [2,3,5,7]
result = sol.minBitwiseArray(nums)
print(f"The minimum bitwise array for nums {nums} is: {result}")