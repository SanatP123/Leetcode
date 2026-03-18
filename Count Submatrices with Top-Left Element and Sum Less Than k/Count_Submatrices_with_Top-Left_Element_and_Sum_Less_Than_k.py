
from typing import List

class Solution:
    def countSubmatrices(self, grid: List[List[int]], k: int) -> int:
        row = len(grid)
        col = len(grid[0])
        res = 0

        # Traverse each cell
        for i in range(row):
            for j in range(col):
                # Build prefix sum for current cell (i, j)
                # Add sum from top
                if i > 0:
                    grid[i][j] += grid[i-1][j]
                # Add sum from left
                if j > 0:
                    grid[i][j] += grid[i][j-1]
                
                # Subtract overlapping sum
                if i > 0 and j > 0:
                    grid[i][j] -= grid[i-1][j-1]
                
                # Check if this submatrix sum is valid
                if grid[i][j] <= k:
                    res += 1
                else:
                    break
        
        return res
                
sol = Solution()
inputs = [[[7,6,3],[6,6,1]], [[7,2,9],[1,5,0],[2,6,6]]]
k_values = [18, 20]
for grid, k in zip(inputs, k_values):
    print(f"Input: grid = {grid}, k = {k}")
    print(f"Output: {sol.countSubmatrices(grid, k)}\n")