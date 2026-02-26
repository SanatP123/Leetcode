class Solution:
    def numSteps(self, s: str) -> int:
        # Convert binary representation to string
        n = int(s,2)
        count = 0

        # Until the number reduces to 1
        while n != 1:
            
            # If current number is even divide by 2
            if n % 2 == 0:
                n = n//2

            # If current number is odd, add 1 to it
            else:
                n = n + 1

            # Increment steps
            count += 1

        return count

sol = Solution()
# Example 1
inputs = ["1101","10","1"]
for i, s in enumerate(inputs):
    print(f"Input: {s}")
    print(f"Output: {sol.numSteps(s)}")  # Output
