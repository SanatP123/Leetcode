class Solution:
    def addBinary(self, a: str, b: str) -> str:
        # Initialize two pointers to traverse the binary strings from right to left
        i = len(a) - 1
        j = len(b) - 1

        res = []
         # Variable to store the carry-over value
        carry = 0

        while i >= 0 or j >= 0 or carry:
            total = carry

            # Add the current binary digit in string 
            if i >= 0:
                total += int(a[i])
                i -= 1
            
            if j >= 0:
                total += int(b[j])
                j -= 1
            
            # Calculate the next binary digit in the result
            res.append(str(total%2))
            # Calculate the next carry-over value by dividing the sum by 2
            carry = total // 2
        
        return "".join(res[::-1])

sol = Solution()
inputs = [("11","1"),("1010","1011"),("0","0")]
for a,b in inputs:
    print(f"Input: a = {a}, b = {b}")
    print(f"Output: {sol.addBinary(a,b)}\n")

