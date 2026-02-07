class Solution:
    def minimumDeletions(self, s: str) -> int:
        left_b = 0
        
        right_a = s.count('a')
        n = len(s)
        i = 0
        ans = right_a

        while i < n:
            

            # move s[i] from right side to left side
            if s[i] == "b":
                left_b += 1
            elif s[i] == "a":
                right_a -= 1
            
            # split after index i
            ans = min(ans,left_b + right_a)
        
            i += 1
        
        return ans



sol = Solution()
inputs = ["aababbab", "bbaaaaabb", "aaaaaa", "bbbbbb"]

for s in inputs:
    print(f"Input: s = {s}")
    print(f"Output: {sol.minimumDeletions(s)}\n")
