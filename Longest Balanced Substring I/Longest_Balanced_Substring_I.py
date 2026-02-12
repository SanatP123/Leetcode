
from collections import defaultdict


class Solution:
    def longestBalanced(self, s: str) -> int:
        n = len(s)
        max_len = 0

        
        for i in range(n):
            freq = defaultdict(int)
            for j in range(i,n):
                freq[s[j]] += 1
                
                if min(freq.values()) == max(freq.values()):
                    max_len = max(max_len, j - i + 1)

        return max_len


sol = Solution()

inputs = ["aabbab","abcde","aabbccdd","abbac","zzabccy","aba"]

for s in inputs:
    print(f"Input: s = {s}")
    print(f"Output: {sol.longestBalanced(s)}\n")

