class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        # S1 = "0"
        # S2 = "0" + "1" + "1"
        # S3 = "011" + "1" + "001"

        def invertandreverse(string):
            dicts = {'0':'1','1':'0'} 
            inverse_s = ''
            for i in string:
                inverse_s += dicts[i]

            return inverse_s[::-1]

        if k == 1:
            return "0"
        prev = "0"
        curr = ""
        
        while n > 0:
            
            curr = prev + "1" + invertandreverse(prev)
            n -= 1
            prev = curr

            if len(curr) >= k:
                break

        return curr[k-1]
            
        

sol = Solution()
inputs = [(3, 1), (4, 11), (1, 1), (2, 3), (3, 5)] # "0", "1",
for n, k in inputs:
    print(f"Input: n = {n}, k = {k}")
    print(f"Output: {sol.findKthBit(n, k)}\n")