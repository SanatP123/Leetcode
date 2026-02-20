class Solution:
    def makeLargestSpecial(self, s: str) -> str:
        balance = 0
        start = 0
        res = []
        
        for i,ch in enumerate(s):
            if ch == '1':
                balance += 1
            if ch == '0':
                balance -= 1
            

            if balance == 0:
                inner = self.makeLargestSpecial(s[start+1:i])
                res.append("1" + inner + "0")
                start = i + 1
        
        res.sort(reverse = True)

        return "".join(res)

sol = Solution()
inputs = ["11011000","10"]
for s in inputs:
    print(f"Input: s = {s}")
    print(f"Output: {sol.makeLargestSpecial(s)}\n")