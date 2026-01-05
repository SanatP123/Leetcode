
from typing import List


class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        total_sum = 0
        negatives = 0
        min_abs_value = float('inf')

        for row in matrix:
            for value in row:
                total_sum += abs(value)
                if value < 0:
                    negatives += 1
                min_abs_value = min(min_abs_value, abs(value))
        
        if negatives % 2 == 1:
            total_sum -= 2 * min_abs_value
        
        return total_sum
        


s = Solution()

# Updated test cases based on the examples provided

inputs = [[[1,-1],[-1,1]],[[1,2,3],[-1,-2,-3],[4,5,6]],[[ -1,-2,-3],[-4,5,6],[7,8,9]],[[1,2,3],[-1,-2,-3],[1,2,3]]]

# Running the test cases
for matrix in inputs:
    print(f"Input: matrix = {matrix}")
    print(f"Output: {s.maxMatrixSum(matrix)}\n")