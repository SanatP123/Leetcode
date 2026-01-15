
from typing import List

class Solution:
    def maximizeSquareHoleArea(self, n: int, m: int, hBars: List[int], vBars: List[int]) -> int:
        def check_gaps(bars):
            if not bars:
                return 1
            bars.sort()

            current = 1
            longest = 1

            for i in range(1,len(bars)):
                if bars[i] == bars[i-1] + 1:
                    current += 1
                else:
                    longest = max(longest,current)
                    current = 1
            
            longest = max(longest,current)
            return longest + 1
        
        h_gap = check_gaps(hBars)
        v_gap = check_gaps(vBars)

        side = min(h_gap,v_gap)

        return side * side


sol = Solution()
n = 5
m = 5
hBars = [2,4]
vBars = [2]
result = sol.maximizeSquareHoleArea(n, m, hBars, vBars)
print(f"The maximum area of the square hole is: {result}")

