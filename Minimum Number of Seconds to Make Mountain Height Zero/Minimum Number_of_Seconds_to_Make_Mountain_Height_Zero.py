
from typing import List
import heapq

class Solution:
    def minNumberOfSeconds(self, mountainHeight: int, workerTimes: List[int]) -> int:
        INF = 10**9

        # Min heap
        heap = []
        # Push first job for each worker
        for work in workerTimes:
            heapq.heappush(heap, (work, work, 2))
        
        mintime = -INF

        # Remove mountain units
        for _ in range(mountainHeight):
            
            # Earliest worker
            curr, worktime, multiplier = heapq.heappop(heap)
            
            # Update answer
            mintime = max(mintime, curr)

            # Next finish time
            curr += worktime * multiplier

            # Push next task
            heapq.heappush(heap, (curr, worktime, multiplier + 1))
        
        return mintime

sol = Solution()
inputs = [(4, [2,1,1]), (10, [3,2,2,4]), (5, [1])] # 3, 12, 15
for mountainHeight, workerTimes in inputs:
    print(f"Input: mountainHeight = {mountainHeight}, workerTimes = {workerTimes}")
    print(f"Output: {sol.minNumberOfSeconds(mountainHeight, workerTimes)}\n")