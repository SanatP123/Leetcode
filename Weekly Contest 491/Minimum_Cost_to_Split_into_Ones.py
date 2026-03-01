
from functools import cache

class Solution:
    def minCost(self, n: int) -> int:
        @cache
        def dp(x):
            # Base case: already one
            if x == 1:
                return 0
            
            curr = float("inf")
            
            for a in range(1,x//2 + 1):
                b = x - a
                # Cost of split + subproblems
                curr = min(curr,a*b + dp(a) + dp(b))
            
            return curr
        
        return dp(n)


# The School Problem
# Legend says:
# When Gauss was a child, his teacher allegedly asked the class to compute:
# 1 + 2 + 3 + ⋯ + 100
# The teacher expected the students to take a long time adding manually.
# Gauss returned the answer almost immediately: 5050.

# class Solution:
#     def minCost(self, n: int) -> int: 
#         return n * (n - 1) // 2

s = Solution()
inputs = [3,4] # 3,6
for i in inputs:    print(s.minCost(i))
