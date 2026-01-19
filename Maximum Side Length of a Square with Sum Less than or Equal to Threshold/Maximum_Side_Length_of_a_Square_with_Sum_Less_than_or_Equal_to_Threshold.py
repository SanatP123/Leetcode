
from typing import List


class Solution:
    def maxSideLength(self, mat: List[List[int]], threshold: int) -> int:
        # Number of rows and columns in the matrix
        rows = len(mat)
        cols = len(mat[0])

        # Build 2D Prefix Sum Array
        prefix_sum = [[0] * (cols + 1) for _ in range(rows + 1)]
        for i in range(1, rows + 1):
            for j in range(1, cols + 1):
                # remove double-counted area
                prefix_sum[i][j] = mat[i-1][j-1] + prefix_sum[i-1][j] + prefix_sum[i][j-1] - prefix_sum[i-1][j-1]
        
        # Helper function to check if there exist kxk square
        def check(k):
            current_sum = 0
            for i in range(k,rows+1):
                for j in range(k,cols+1):
                    # Formula:
                    # bottomRight - top - left + topLeft
                    current_sum = prefix_sum[i][j] + prefix_sum[i-k][j-k] - prefix_sum[i][j-k] - prefix_sum[i-k][j]
                    if current_sum <= threshold:
                        return True
            return False

    # Binary Search on side length
        low = 1
        high = min(rows,cols)
        ans = 0
        
        while low <= high:
            mid = (low + high)//2
            if check(mid):
                ans = mid 
                low = mid + 1
            else:
                high = mid - 1

        return ans


sol = Solution()
mat = [[1,1,3,2,4,3,2],
      [1,1,3,2,4,3,2],
      [1,1,3,2,4,3,2]]
threshold = 4
result = sol.maxSideLength(mat, threshold)
print(f"The maximum side length of a square with sum less than or equal to {threshold} is: {result}")