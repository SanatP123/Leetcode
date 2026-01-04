class Solution:
    def largestEven(self, s: str) -> str:
        n = len(s)
        i = (n-1)
        while i >= 0:
            if s[i] == "2":
                return s
            else:
                s = s[:i] + s[i+1:]

            i -= 1

            if not s:
                return ""
            



s = Solution()

# Updated test cases based on the examples provided
inputs = ["1","221","1112","1234", "4321", "1357", "2468", "9876543210"]

# Running the test cases
for s_input in inputs:
    print(f"Input: s = \"{s_input}\"")
    print(f"Output: \"{s.largestEven(s_input)}\"\n")

