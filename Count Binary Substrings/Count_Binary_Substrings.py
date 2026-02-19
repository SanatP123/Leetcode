class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        res = 0
        prev = 0
        streak = 1

        for i in range(1,len(s)):
            if s[i] == s[i-1]:
                # Still in the same group extend it
                streak += 1
            else:
                # Group changed, store in prev and reset streak
                prev = streak
                streak = 1
            
            # Choose min streak between current and prev
            if streak <= prev:
                res += 1
        
        return res

sol = Solution()
inputs = ["00110011","10101"]
for s in inputs:
    print(f"Input: s = {s}")
    print(f"Output: {sol.countBinarySubstrings(s)}\n")

