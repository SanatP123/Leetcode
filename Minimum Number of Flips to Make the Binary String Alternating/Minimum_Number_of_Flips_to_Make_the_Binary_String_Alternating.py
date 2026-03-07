class Solution:
    def minFlips(self, s: str) -> int:
        n = len(s)

        # Double the string to simulate all rotations
        s = s + s

        alt1 = []
        alt2 = []

        for i in range(len(s)):
            # Pattern starting with 0
            alt1.append('0' if i % 2 == 0 else '1')

            # Pattern starting with 1
            alt2.append('1' if i % 2 == 0 else '0')
        
        res = float('inf')
        # Mismatch counts for both patterns
        diff1 = 0  
        diff2 = 0
        left = 0

        for right in range(len(s)):
            if s[right] != alt1[right]:
                diff1 += 1  # mismatch with alt1
            if s[right] != alt2[right]:
                diff2 += 1  # mismatch with alt2
            
             # Keep window size equal to original string
            if right - left + 1 > n:
                if s[left] != alt1[left]:
                    diff1 -= 1
                if s[left] != alt2[left]:
                    diff2 -= 1
                left += 1
                
             # Choose min flips for this rotation
            if right - left + 1 == n:
                res = min(res,diff1,diff2)
        
        return res


        
sol = Solution()
inputs = ["111000", "010", "1110"] # 2, 0, 1
for s in inputs:
    print(f"Input: s = {s}")
    print(f"Output: {sol.minFlips(s)}\n")