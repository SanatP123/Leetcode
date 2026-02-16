class Solution:
    def reverseBits(self, n: int) -> int:
        binary_n = bin(n)[2:]
        while len(binary_n) < 32:
            binary_n = "0" + binary_n
        
        return int(binary_n[::-1],2)
        
sol = Solution()
inputs = [43261596,4294967293,2147483644]
for n in inputs:
    print(f"Input: n = {n}")
    print(f"Output: {sol.reverseBits(n)}\n")
