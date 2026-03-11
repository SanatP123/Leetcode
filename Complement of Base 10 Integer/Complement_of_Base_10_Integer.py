class Solution:
    def bitwiseComplement(self, n: int) -> int:
        res = ""
        bin_n = bin(n)[2:]

        for i in bin_n:
            if i == "0":
                res += "1"
            else:
                res += "0"
        
        return int(res,2)

sol = Solution()
inputs = [5, 7, 10] # 2, 0, 5
for n in inputs:
    print(f"Input: n = {n}")
    print(f"Output: {sol.bitwiseComplement(n)}\n")