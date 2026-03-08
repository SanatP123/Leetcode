
from typing import List

class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        sets = []
        # Length of each binary string
        n = len(nums[0])
        

        # Convert all binary strings to base-10 integers
        for i in range(len(nums)):
            sets.append(int(nums[i],2))
        
        # Check all possible binary numbers of length n
        for j in range(2**n):
            if j not in sets:
                # Convert back to binary with leading zeros
                return format(j,f'0{n}b')
        

sol = Solution()
inputs = [["01","10"], ["00","01"], ["111","011","001"]]
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {sol.findDifferentBinaryString(nums)}\n")


#  class Solution:
#     def findDifferentBinaryString(self, nums: List[str]) -> str:
#         # Cantor's diagonal argument
#         res = []

#         # Flip the diagonal bit
#         for i in range(len(nums)):
#             if nums[i][i] == "0":
#                 res.append("1")
#             else:
#                 res.append("0")
        
#         return "".join(res)



        