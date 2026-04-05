import numpy as np

class Solution:
    def findGoodIntegers(self, n: int) -> list[int]:
        good_integers = []
        sum_map = {}

        # Iterate over all valid (a, b) pairs with a <= b 
        for a in range(1, int(np.cbrt(n)+1)):
            for b in range(a,int(np.cbrt(n)+1)):
                x = a**3 + b**3
                if x <= n:
                    sum_map[x] = sum_map.get(x,0) + 1
                else:
                    break # further b only increases x

         # Include sums that can be formed by at least two distinct pairs
        for i,j in sum_map.items():
            if j >= 2:
                good_integers.append(i)
        
        good_integers.sort()
        return good_integers

sol = Solution()
inputs = [4104,578]
for n in inputs:
    print(f"Input: n = {n}")
    print(f"Output: {sol.findGoodIntegers(n)}\n")