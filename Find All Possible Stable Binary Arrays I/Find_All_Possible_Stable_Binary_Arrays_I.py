
from functools import cache


class Solution:
    def numberOfStableArrays(self, zero: int, one: int, limit: int) -> int:
        # Modulus to prevent overflow
        mod = 10 ** 9 + 7

        @cache
        def recursive(zeroleft,onesleft,prev):
            if zeroleft == 0 and onesleft == 0: return 1

            res = 0

            # We can place zeros if previous was not zero
            if prev != 0:
                # Try placing i zeros
                for i in range(1,min(limit,zeroleft) + 1):
                    # Recurse after placing zeros
                    res += recursive(zeroleft - i, onesleft, 0)
                    res %= mod

            # We can place ones if previous was not one
            if prev != 1:
                for j in range(1,min(limit,onesleft) + 1):
                    # Recurse after placing one
                    res += recursive(zeroleft,onesleft - j, 1)
                    res %= mod

            return res % mod
        
         # Start recursion with no previous block
        return recursive(zero,one,-1) 

sol = Solution()
inputs = [(1,1,2), (3,3,2), (1,2,1)] # 2, 14, 1
for zero, one, limit in inputs:
    print(f"Input: zero = {zero}, one = {one}, limit = {limit}")
    print(f"Output: {sol.numberOfStableArrays(zero, one, limit)}\n")