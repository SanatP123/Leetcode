class Solution:
    def minOperations(self, s: str, k: int) -> int:
        # Total length of the binary string
        n = len(s)

        # Count how many zeros we must eliminate
        z = s.count('0')

        # If there are no zeros, the string is already all '1's
        if z == 0:
            return 0
        
        # Special case: if k == n, every operation flips the entire string
        if n == k:
            # If the string is all zeros, one flip makes it all ones
            # Otherwise, it will alternate forever and never become all ones
            return 1 if z == n else -1
        
        # Number of bits NOT flipped in each operation
        # (since we must flip exactly k bits)
        b = n - k

        # Lower bound 1:
        # Each operation can remove at most k zeros.
        # So minimum operations needed is ceil(z / k)
        k1 = (z + k - 1) // k

        # Initialize result as infinity (meaning no valid solution yet)
        res = float("inf")

        # -------------------------
        # Case 1: Try odd number of operations
        # -------------------------

        # Parity condition:
        # After each operation, zero count changes by (k - 2x).
        # Since 2x is always even, parity changes only if k is odd.
        # This checks if an odd number of operations can lead to zero.
        if (k & 1) == (z & 1):

            # Lower bound 2:
            # Prevent creating too many new zeros while flipping.
            # Another ceil constraint.
            t = (n - z + b - 1) // b

            # We must satisfy both lower bounds.
            # Take the maximum.
            # Then force it to be odd using bitwise OR with 1.
            res = max(k1, t) | 1
        
        # -------------------------
        # Case 2: Try even number of operations
        # -------------------------

        # If zero count is even, it's possible to reach zero
        # with an even number of operations.
        if (z & 1) == 0:

            # Another bound ensuring feasibility
            t = (z + b - 1) // b

            # Must satisfy both lower bounds
            e = max(k1, t)

            # Force e to be even:
            # If e is odd, add 1 to make it even.
            e += e & 1

            # Choose the smaller valid answer
            if e < res:
                res = e
        
        # If no valid solution found, return -1
        # Otherwise return computed minimum operations
        return -1 if res == float("inf") else res
    
sol = Solution()
# Example 1
inputs =  [("110",1),("101",2),("1010",2),("1111",4),("0000",4),("100101",3),("0101",3)]
for i, (s, k) in enumerate(inputs):
    print(f"Input: s = {s}, k = {k}")
    print(f"Output: {sol.minOperations(s, k)}")  # Output
