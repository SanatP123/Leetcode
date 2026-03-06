class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        left = 0
        # Tracks if we've already seen a segment of '1's
        seen = False

        while left < len(s):
            if s[left] == "1":
                # Second segment found
                if seen:
                    return False
                 # Skip the entire block of consecutive '1's
                while left < len(s) and s[left] == "1":
                    left += 1
                seen = True
            else:
                left += 1
        
        return True

sol = Solution()
inputs = ["1001", "110", "101", "1111", "0000"] # False, True, False, True, True
for s in inputs:
    print(f"Input: s = {s}")
    print(f"Output: {sol.checkOnesSegment(s)}\n")