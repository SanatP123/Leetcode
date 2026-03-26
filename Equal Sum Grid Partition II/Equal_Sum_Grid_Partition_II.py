from typing import List
from collections import Counter


class Solution:
    def canPartitionGrid(self, grid: List[List[int]]) -> bool:

        # Checks if we can make a valid horizontal cut on grid g
        def check(g):
            m = len(g)
            n = len(g[0])

            # Need at least 2 rows to make a horizontal cut
            if m < 2:
                return False
            
             # Frequency map of the "bottom" section
            bot_freq = Counter()
            for r in range(m):
                for c in range(n):
                    bot_freq[g[r][c]] += 1
            
            # Frequency map for the "top" section
            top_freq = Counter()

            # Precompute row sums for fast updates
            row_sums = [sum(row) for row in g]
            total_sum = sum(row_sums)
            top_sum = 0

            # Try every horizontal cut: split between row r-1 and r
            for r in range(1,m):
                for c in range(n):
                    # Move row (r-1) from bottom → top
                    v = g[r-1][c]
                    top_freq[v] += 1
                    bot_freq[v] -= 1

                    if bot_freq[v] == 0:
                        del bot_freq[v]

                top_sum += row_sums[r-1]
                bot_sum = total_sum - top_sum

                # Case 1: perfectly equal split
                if top_sum == bot_sum:
                        return True

                # Difference we need to fix by removing ONE cell
                diff = abs(top_sum - bot_sum)

                # Case 2: remove from top section
                if top_sum > bot_sum:
                    if r == 1:
                        if diff == g[0][0] or diff == g[0][n-1]:
                            return True
                    elif n == 1:
                        if diff == g[0][0] or diff == g[r-1][0]:
                            return True
                    elif diff in top_freq:
                        return True
                # Case 3: remove from bottom section    
                else:
                    bot_rows = m - r
                    if bot_rows == 1:
                        if diff == g[r][0] or diff == g[r][n-1]:
                            return True
                        
                    elif n == 1:
                        if diff == g[r][0] or diff == g[m-1][0]:
                            return True
                        
                    elif diff in bot_freq:
                        return True
            return False
        
        # Try horizontal cuts
        if check(grid):
            return True
        
        # Try vertical cuts by transposing the grid
        transposed = [[grid[r][c] for r in range(len(grid))] for c in range(len(grid[0]))]

        return check(transposed)
    
sol = Solution()
inputs = [[[1,4],[2,3]], [[1,2],[3,4]], [[1,2,4],[2,3,5]], [[4,1,8],[3,2,6]]]
for grid in inputs:
    print(f"Input: grid = {grid}")
    print(f"Output: {sol.canPartitionGrid(grid)}\n")