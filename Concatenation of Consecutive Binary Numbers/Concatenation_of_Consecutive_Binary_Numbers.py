class Solution:
    def concatenatedBinary(self, n: int) -> int:
        concat = ""
        for i in range(1,n+1):
            bin_i = bin(i)[2:]
            concat += bin_i
        
        return int(concat,2) % (10**9 + 7)
        
s = Solution()
inputs = [1,3,12] # 1,27,505379714]
for i in inputs:
    print(s.concatenatedBinary(i))
