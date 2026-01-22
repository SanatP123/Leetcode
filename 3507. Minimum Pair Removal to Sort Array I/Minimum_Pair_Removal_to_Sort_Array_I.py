
from typing import List
class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
       
        count = 0

        while len(nums) > 1:
            isincreasing = True
            min_sum = float("inf")
            target = -1
            
            for i in range(len(nums)-1):
                pair_sum = nums[i] + nums[i+1]

                if nums[i] > nums[i+1]:
                    isincreasing = False
                
                if pair_sum < min_sum:
                    min_sum = pair_sum
                    target = i
            
            if isincreasing:
                break
            
            count += 1
            nums[target] = min_sum
            nums.pop(target + 1)
        
        return count


sol = Solution()
nums = [5,2,3,1]
result = sol.minimumPairRemoval(nums)
print(f"The minimum number of pair removals to sort the array {nums} is: {result}")