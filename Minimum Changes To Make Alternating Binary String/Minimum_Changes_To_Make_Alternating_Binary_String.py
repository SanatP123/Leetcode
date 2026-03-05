class Solution:
    def minOperations(self, s: str) -> int:
        
        count1 = 0
        count2 = 0  

        for i in range(len(s)):
            # pattern starting with '1' -> "1010..."
            if s[i] != ('1' if i % 2 == 0 else '0'):
                count1 += 1
            # pattern starting with '0' -> "0101..."
            if s[i] != ('0' if i % 2 == 0 else '1'):
                count2 += 1

        return min(count1,count2) 

sol = Solution()
inputs = ["0100", "10", "1111"] # 1, 0, 2
for s in inputs:
    print(f"Input: s = {s}")
    print(f"Output: {sol.minOperations(s)}\n")