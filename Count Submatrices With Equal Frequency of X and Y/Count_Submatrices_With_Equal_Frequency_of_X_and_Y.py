from typing import List

class Solution:
    def numberOfSubmatrices(self, grid: List[List[str]]) -> int:
        row = len(grid)
        col = len(grid[0])

        # Convert grid
        for i in range(row):
            for j in range(col):
                if grid[i][j] =='X':
                    grid[i][j] = 1
                
                if grid[i][j] == 'Y':
                    grid[i][j] = -1
                
                if grid[i][j] == '.':
                    grid[i][j] = 0
        

        ps = [[0]*col for _ in range(row)]
        px = [[0]*col for _ in range(row)]

        # Build prefix arrays
        for i in range(row):
            for j in range(col):
                val = grid[i][j]
                is_x = 1 if val == 1 else 0

                ps[i][j] = val
                px[i][j] = is_x

                if i > 0:
                    ps[i][j] += ps[i-1][j]
                    px[i][j] += px[i-1][j]

                if j > 0: 
                    ps[i][j] += ps[i][j-1]
                    px[i][j] += px[i][j-1]
                
                if i > 0 and j > 0:
                    ps[i][j] -= ps[i-1][j-1]
                    px[i][j] -= px[i-1][j-1]
        
        # Count valid submatrices
        ans = 0
        for i in range(row):
            for j in range(col):
                if ps[i][j] == 0 and px[i][j] == 1:
                    ans += 1
        return ans


sol = Solution()
inputs = [[["X","Y","."],["Y",".","."]], [["X","X"],["X","Y"]], [[".","."],[".","."]]]
for grid in inputs:
    print(f"Input: grid = {grid}")
    print(f"Output: {sol.numberOfSubmatrices(grid)}\n")