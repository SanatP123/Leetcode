class Solution:
    def binaryGap(self, n: int) -> int:
        max_distance = float("-inf")

        # Binary representation of n
        bin_n = bin(n)[2:]
        
        # If there are no two adjacent 1's, return 0
        if bin_n.count('1') <= 1: return 0

        left = 0
        right = 1

        while right < len(bin_n):
            # Find two adjacent 1's and calculate the distance
            if bin_n[left] == bin_n[right] == '1':
                max_distance = max(max_distance, right - left)
                left = right
            right += 1

        return max_distance

sol = Solution()
inputs = [22, 5, 6, 8]
for n in inputs:
    print(f"Input: n = {n}")
    print(f"Output: {sol.binaryGap(n)}\n")