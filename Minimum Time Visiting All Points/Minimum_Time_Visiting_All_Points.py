
from typing import List


class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        sec = 0
        for i in range(1,len(points)):
            current_x, current_y = points[i-1]
            target_x, target_y = points[i]

            dx, dy = abs(target_x - current_x), abs(target_y - current_y)

            sec += max(dx,dy)

        return sec



sol = Solution()
points = [[1,1],[3,4],[-1,0]]
result = sol.minTimeToVisitAllPoints(points)
print(f"The minimum time to visit all points is: {result}")

