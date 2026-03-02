from typing import List
class Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        n = len(grid)
        # Store count of trailing zeros for each row
        zeroes = []

        for row in grid:
            count = 0
            for j in range(n-1,-1,-1):
                if row[j] == 0:
                    count += 1
                else:
                    break
            zeroes.append(count)

        swaps = 0
        for i in range(n):
            # Required trailing zeros for row i
            needed = n - i - 1
            j = i
            # Find a row with enough trailing zeros
            while j < n and zeroes[j] < needed:
                j += 1
            if j == n:
                return -1
            while j > i:
                # Swap upward
                zeroes[j], zeroes[j-1] = zeroes[j-1], zeroes[j]
                j -= 1
                swaps += 1
            
        return swaps


sol = Solution()
inputs = [[[0,0,1],[1,1,0],[1,0,0]], [[0,1,1],[1,0,1],[1,1,0]], [[1,0,0],[1,1,0],[1,1,1]]] # 3, 0, -1
for grid in inputs:
    print(f"Input: grid = {grid}")
    print(f"Output: {sol.minSwaps(grid)}\n")