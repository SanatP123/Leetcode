from typing import List
class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        row, col = len(matrix), len(matrix[0])

        # Calculate Heights for Each Column
        for i in range(1,row):
            for j in range(col):
                if matrix[i][j] == 1:
                    matrix[i][j] += matrix[i-1][j]
        
        res = 0

        # Calculate Maximum Area
        for i in range(row):
             # Sort the heights in descending order
            matrix[i].sort(reverse = True)

            # Iterate through the sorted heights
            for j in range(col):
                height = matrix[i][j]
                width = j + 1
                
                # Calculate the area using the current height and remaining width
                res = max(res, height * width)
        
        return res

sol = Solution()
inputs = [[[0,0,1],[1,1,1],[1,0,1]], [[1,0,1,0,1]], [[1,1,0],[1,0,1]]]
for matrix in inputs:
    print(f"Input: matrix = {matrix}")
    print(f"Output: {sol.largestSubmatrix(matrix)}\n")  