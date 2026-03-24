from typing import List
class Solution:
    def constructProductMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        m = len(grid)
        n = len(grid[0])
        mod = 12345
    
        # Flatten the grid
        arr = []

        for i in range(m):
            for j in range(n):
                arr.append(grid[i][j])
        
        size = len(arr)

        # Prefix
        prefix = [1] * size
        for i in range(1,size):
            prefix[i] = (prefix[i-1] * arr[i-1]) % mod
        
        # Suffix
        suffix = [1] * size
        for j in range(size-2,-1,-1):
            suffix[j] = (suffix[j+1] * arr[j+1]) % mod
        
        # Build Result
        res = [0] * size
        for i in range(size):
            res[i] = (prefix[i] * suffix[i]) % mod

        # Convert back to 2D
        ans = [[0] * n for _ in range(m)]
        idx = 0
        for i in range(m):
            for j in range(n):
                ans[i][j] = res[idx]
                idx += 1

        return ans
        
        

sol = Solution()
inputs = [[[1,2],[3,4]], [[2,3,4],[5,6,7],[8,9,10]],[[12345],[2],[1]]]
for grid in inputs:
    print(f"Input: grid = {grid}")
    print(f"Output: {sol.constructProductMatrix(grid)}\n")