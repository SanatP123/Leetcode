from typing import List

class Solution:
    def binarySearchableNumbers(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 1:
            return n
        
        left_max = [float('-inf')] * n
        right_min = [float('inf')] * n

        current_max = nums[0]

        
        for i in range(1,n):
            left_max[i] = current_max
            current_max = max(nums[i],current_max)
            
        
        current_min = nums[-1]
        for j in range(n-2,-1,-1):
            right_min[j] = current_min
            current_min = min(nums[j], current_min)
            
        
        
        values = 0
        for i in range(len(nums)):
            if left_max[i] < nums[i] < right_min[i]:
                values += 1
        
        return values
    



s = Solution()

# Adding test cases for the given examples
inputs = [
    [7],
    [-1,5,2],
    [1, 3, 2],  # Example 1
    [1, 2, 3, 4],  # Example 2
    [4, 3, 2, 1],  # Example 3
    [1, 2, 2, 3, 4],  # Example 4
    [1]  # Example 5
]

# Running the test cases
for nums in inputs:
    print(f"Input: nums = {nums}")
    output = s.binarySearchableNumbers(nums)
    print(f"Output: {output}\n")

