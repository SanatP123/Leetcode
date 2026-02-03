from typing import List
class Solution:
    # def isTrionic(self, nums: List[int]) -> bool:
    #     res = []
    #     stack = []
    #     for i in range(1,len(nums)):
    #         if nums[i] == nums[i-1]:
    #             return False
    #         if nums[i-1] < nums[i]:
    #            res.append(True)
    #         else:
    #             res.append(False)
        
    #     for i in res:
    #         if stack and stack[-1] == i:
    #             continue
    #         stack.append(i)
        
    #     return stack == [True,False,True]

                
        
    def isTrionic(self, nums: List[int]) -> bool:
        n = len(nums)
        if n < 4 or nums[0] >= nums[1]:
            return False
        
        flips = 0
        direction = 1

        for i in range(1,n):
            if direction * nums[i-1] > direction * nums[i]:
                flips += 1
                direction *= -1
            
            if nums[i-1] == nums[i] or flips > 2:
                return False

        return flips == 2

s = Solution()
inputs = [[1,3,5,4,2,6], [2,1,3], [5,3,4,2,1], [1,2,3,4], [3,1,2,1,3,4,3]]
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {s.isTrionic(nums)}\n")

