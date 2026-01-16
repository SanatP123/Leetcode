
from typing import List


class Solution:
    def maximizeSquareArea(self, m: int, n: int, hFences: List[int], vFences: List[int]) -> int:
        MOD = 10**9 + 7

        h = sorted(hFences + [1, m])
        v = sorted(vFences + [1, n])

        # Compute all horizontal gaps
        h_gaps = set()

        for i in range(len(h)):
            for j in range(i+1,len(h)):
                h_gaps.add(h[j] - h[i])
        
        max_side = 0

        # Compute Vertical gaps and check intersection

        for i in range(len(v)):
            for j in range(i+1,len(v)):
                gap = v[j] - v[i]
                if gap in h_gaps:
                    max_side = max(max_side,gap)
        
        if max_side == 0:
            return -1
        return max_side * max_side % MOD

sol = Solution()
m = 4
n = 3
hFences = [2,3]
vFences = [2]
result = sol.maximizeSquareArea(m, n, hFences, vFences)
print(f"The maximum area of the square by removing fences is: {result}")
