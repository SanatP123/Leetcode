from typing import List
class Solution:
    def reverseSubmatrix(self, grid: List[List[int]], x: int, y: int, k: int) -> List[List[int]]:

        # i → starting row of submatrix
        # j → ending row of submatrix
        i = x
        j = x + k - 1

        # Swap rows from top and bottom moving inward
        while i < j:
            
            for p in range(y, y+k):
                # Swap all columns within the submatrix width
                grid[i][p], grid[j][p] = grid[j][p], grid[i][p]
            
            i += 1
            j -= 1
        
        return grid

sol = Solution()
inputs = [
    [[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], 1, 0, 3],
    [[[3,4,2,3],[2,3,4,2]], 0, 2, 2]
]
for grid, x, y, k in inputs:
    print(f"Input: grid = {grid}, x = {x}, y = {y}, k = {k}")
    print(f"Output: {sol.reverseSubmatrix(grid, x, y, k)}\n")
