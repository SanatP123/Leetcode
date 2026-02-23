class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        # Set to track all the distinct binary codes
        seen = set()

        left = 0

        
        while left <= len(s) - k:
            subs = s[left:left+k]
            # Add substings of length k in seen
            seen.add(subs)
            left += 1
        
        # The number of distinct sub-strings should be exactly 2^k
        return len(seen) == 2 ** k
        
sol = Solution()
inputs = [("00110110", 2), ("0110", 1), ("0110", 2)]
for s, k in inputs:
    print(f"Input: s = {s}, k = {k}")
    print(f"Output: {sol.hasAllCodes(s, k)}\n")