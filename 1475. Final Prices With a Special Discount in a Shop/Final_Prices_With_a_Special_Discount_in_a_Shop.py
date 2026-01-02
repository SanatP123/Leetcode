from typing import List
class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        stack = []

        for i in range(len(prices)):
            while stack and prices[i] <= prices[stack[-1]]:
                idx = stack.pop()
                prices[idx] -= prices[i]
            stack.append(i)
        
        return prices


s = Solution()

# Adding test cases for the given examples
inputs = [[8,4,6,2,3], [1,2,3,4,5], [10,1,1,6]]

# Running the test cases
for prices in inputs:
    print(f"Input: prices = {prices}")
    output = s.finalPrices(prices)
    print(f"Output: {output}\n")
