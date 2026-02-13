class Solution:
    def longestBalanced(self, s: str) -> int:
        n = len(s)
        ans = 0
        
        # Case 1 : Exactly one distinct character
        
        i = 0
        while i < n:
            j = i
            while j < n and s[j] == s[i]:
                j += 1
            
            ans = max(ans, j - i)
            i = j
        
        # Case 2 : Exactly two distinct characters

        pairs = [('a','b','c'),('a','c','b'),('b','c','a')]

        for ca,cb,skip in pairs:
            maps = {}
            maps[0] = -1
            diff = 0

            for i in range(n):
                c = s[i]
                if c == skip:
                    maps.clear()
                    maps[0] = i
                    diff = 0
                if c == ca:
                    diff += 1
                else:
                    diff -= 1
                
                
                if diff in maps:
                    ans = max(ans, i - maps[diff])
                else:
                    maps[diff] = i

        
        # Case 3 : Exactly three distinct characters

        maps = {}
        maps[(0,0)] = -1
        ca,cb,cc = 0,0,0

        for i in range(n):
            if s[i] == 'a':
                ca += 1
            elif s[i] == 'b':
                cb += 1
            else:
                cc += 1
            
            key = (ca - cb, cb - cc)

            if key in maps:
                ans = max(ans, i - maps[key])
            else:
                maps[key] = i
        
        return ans


sol = Solution()
inputs = ["abbac","aabcc","aba"]
for s in inputs:
    print(f"Input: s = {s}")
    print(f"Output: {sol.longestBalanced(s)}\n")

    

        

