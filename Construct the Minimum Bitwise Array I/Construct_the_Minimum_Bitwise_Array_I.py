
from typing import List


class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        ans = []

        for n in nums:
            check = False
            curr = 0
            for curr in range(n):

                # Check if bitwise OR of curr and curr+1 equals n
                if (curr | curr + 1) == n:
                    check = True
                    ans.append(curr)
                    break
            
            # If no valid curr was found, append -1
            if not check:
                ans.append(-1)
        
        return ans
            

sol = Solution()
nums = [2,3,5,7]
result = sol.minBitwiseArray(nums)
print(f"The minimum bitwise array for nums {nums} is: {result}")
