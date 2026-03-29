class Solution:
    def firstMatchingIndex(self, s: str) -> int:
        n = len(s)
        left = 0

         # Iterate from the start to the middle of the string
        while left <= n//2:
            right = n - left - 1

            # Check if the characters match
            if s[left] == s[right]:
                return left
                
            left += 1
        
        return -1

sol = Solution()
inputs = ["abcacbd", "abcdab", "abc"]
for s in inputs:
    print(f"Input: s = {s}")
    print(f"Output: {sol.firstMatchingIndex(s)}\n")