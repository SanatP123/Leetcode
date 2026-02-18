class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        # Convert int to binary number
        binary_n = bin(n)[2:]
        for i in range(len(binary_n)-1):
            # If the bits don't have different values return false
            if binary_n[i] == binary_n[i+1]:
                return False

        return True

sol = Solution()
inputs = [5,7,11,10,9]
for n in inputs:
    print(f"Input: n = {n}")
    print(f"Output: {sol.hasAlternatingBits(n)}\n")

