
from typing import List
from collections import defaultdict
import heapq
class Solution:
    def minCost(self, n: int, edges: List[List[int]]) -> int:
        # Build graph with normal + reversed edges
        graph = defaultdict(list)

        for u,v,w in edges:
            # Original edge
            graph[u].append((v,w))
            # Original reversed-edge
            graph[v].append((u,w*2))
        
        dist = [float('inf')] * n
        dist[0] = 0
        # Min-heap: (cost, node)
        pq = [(0,0)]

        while pq:
            cost, u = heapq.heappop(pq)

            if cost > dist[u]:
                continue
            if u == n-1:
                return cost

            for v,w in graph[u]:
                new_cost = cost + w
                if new_cost < dist[v]:
                    dist[v] = new_cost
                    heapq.heappush(pq,(new_cost,v))
            
        return -1



                
sol = Solution()
n = 4
edges = [[0,1,3],[3,1,1],[2,3,4],[0,2,2]]
result = sol.minCost(n, edges)
print(f"The minimum cost to reach node {n-1} from node 0 with edge reversals is: {result}")
