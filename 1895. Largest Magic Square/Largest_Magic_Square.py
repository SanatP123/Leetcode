
from typing import List


class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        def check(magic):
            k = len(magic)
            target = sum(magic[0])

            for i in range(1,len(magic)):
                if sum(magic[i]) != target:
                    return False
            
            for j in range(len(magic[0])):
                if sum(magic[i][j] for i in range(len(magic))) != target:
                    return False
            
            diag_sum = 0
            for i in range(len(magic)):
                for j in range(len(magic[0])):
                    if i == j:
                        diag_sum += magic[i][j]
            
            if diag_sum != target:
                return False
            
            anti_diag = 0
            for i in range(len(magic)):
                anti_diag += magic[i][k-i-1]

            return diag_sum == anti_diag == target
    

        for k in range(min(m,n),1,-1):
            for r in range(m-k+1):
                for c in range(n-k+1):
                    square = [grid[r + i][c:c + k] for i in range(k)]
                    if check(square):
                        return k
        
        return 1


sol = Solution()
grid = [[7,1,4,5,6],[2,5,1,6,4],
        [1,5,4,3,2],[1,2,7,3,4]]
result = sol.largestMagicSquare(grid)
print(f"The size of the largest magic square is: {result}")