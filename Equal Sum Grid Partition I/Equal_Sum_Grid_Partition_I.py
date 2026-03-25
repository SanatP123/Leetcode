from typing import List
class Solution:
    def canPartitionGrid(self, grid: List[List[int]]) -> bool:
        m = len(grid)
        n = len(grid[0])

        # Compute row and column prefix sum
        row_sum = [0] * m
        col_sum = [0] * n
        total = 0

        for i in range(m):
            for j in range(n):
                row_sum[i] += grid[i][j]
                col_sum[j] += grid[i][j]
                total += grid[i][j]
        
        # If total sum is odd, we cannot split into two equal parts
        if total % 2 == 1:
            return False
        
        # Helper function to check if an array can be split into two parts with equal sum
        def check(arr,total):
            left = arr[0]
            right = total - left

            for i in range(1,len(arr)):
                if left == right:
                    return True
                if left > right:
                    return False
                
                # Move current element from right partition to left
                left += arr[i]
                right -= arr[i]
            
            return False

        
        # Check if we can split horizontally (between rows)
        if check(row_sum,total):
            return True
        # Check if we can split vertically (between cols)
        if check(col_sum, total):
            return True
        
        return False

sol = Solution()
inputs = [[[1,4],[2,3]], [[1,3],[2,4]], [[1,2],[3,4]]]
for grid in inputs:
    print(f"Input: grid = {grid}")
    print(f"Output: {sol.canPartitionGrid(grid)}\n")