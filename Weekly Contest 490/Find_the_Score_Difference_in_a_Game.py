from typing import List
class Solution:
    def scoreDifference(self, nums: List[int]) -> int:

        first_score = 0
        second_score = 0

        # Boolean variable to swap player roles
        swap = True

        for i in range(len(nums)):
            # IF nums[i] is odd, swap the player roles
            
            if nums[i] % 2 != 0:
                swap = not swap
            
            # Swap roles every 6th game
            if (i+1) % 6 == 0:
                swap = not swap
            
            if swap:
                first_score += nums[i]
            else:
                second_score += nums[i]         
            
        
        return first_score - second_score 


sol = Solution()
inputs = [[1,2,3],[2,4,2,1,2,1],[57,47,98,35,14,17,12,24,56,58,72,72,66,53,14,4,12,46,71,12,77,77,42,50,2,38,53,50,100,11,93,72,32,74,67,22,88,49,22,18,35,39,35,64,19,9,22,56,36], [1]]
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {sol.scoreDifference(nums)}\n")