
from typing import List


class Solution:
    def largestSquareArea(self, bottomLeft: List[List[int]], topRight: List[List[int]]) -> int:
        n =len(bottomLeft)
        side = 0

        for i in range(n):
            ai,bi = bottomLeft[i]
            ci,di = topRight[i]
            for j in range(i+1,n):
                aj, bj = bottomLeft[j]
                cj, dj = topRight[j]

                height = min(cj,ci) - max(aj,ai)
                width = min(dj,di) - max(bj,bi)

                side = max(side,min(height,width))
        
        return side * side


sol = Solution()
bottomLeft = [[1,1],[2,2]]
topRight = [[3,3],[4,4]]
result = sol.largestSquareArea(bottomLeft, topRight)
print(f"The largest area of square inside two rectangles is: {result}")