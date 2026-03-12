class Solution:
    def minOperations(self, s: str) -> int:
        n = len(s)
        # Case 0
        if s == ''.join(sorted(s)):
            return 0
        # Impossible case
        if n == 2:
            return -1
        
        min_s = min(s)
        max_s = max(s)

        # Case 1
        if s[0] == min_s or s[-1] == max_s:
            return 1

        # Check prefix/suffix
        min_s_prefix = min_s in s[:-1]
        max_s_suffix = max_s in s[1:]

        if not min_s_prefix and not max_s_suffix:
            return 3
        
        return 2


sol = Solution()
inputs = ["dog", "card", "gf"] # 1,2,-1
for s in inputs:
    print(f"Input: s = \"{s}\"")
    print(f"Output: {sol.minOperations(s)}\n")