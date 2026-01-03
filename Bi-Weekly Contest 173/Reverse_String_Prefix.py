class Solution:
    def reversePrefix(self, s: str, k: int) -> str:
        rev = []
        n = len(s)
        for i in range(k):
            rev.append(s[i])

        rev = rev[::-1]
        for i in range(k,n):
            rev.append(s[i])

        return "".join(rev)
            

s = Solution()

# Updated test cases based on the examples provided
inputs = [("abcd", 2), ("xyz", 3), ("hey", 1)]

# Running the test cases
for s_input, k in inputs:
    print(f"Input: s = \"{s_input}\", k = {k}")
    print(f"Output: \"{s.reversePrefix(s_input, k)}\"\n")