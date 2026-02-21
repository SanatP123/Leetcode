class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:

        # Helper Function to check if the number of set bits are prime
        def check_prime(n):
            if n == 0 or n == 1:
                return False

            for i in range(2,n):
                if n % i == 0:
                    return False
            return True
                
        
        result = 0

        for num in range(left,right+1):
            # Convert num to binary
            bin_n = bin(num)[2:]

            # Count set bits
            set_bits = bin_n.count('1')

            # If set bits are prime increment the result
            if check_prime(set_bits):
                result += 1
        
        return result


sol = Solution()
inputs = [(6,10),(10,15)]
for left, right in inputs:
    print(f"Input: left = {left}, right = {right}")
    print(f"Output: {sol.countPrimeSetBits(left, right)}\n")
    