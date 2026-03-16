class Solution:
    def countCommas(self, n: int) -> int:
        total_commas = 0
        divisor = 1000
        while n >= divisor:
            # Numbers from divisor..n contribute one comma at this level
            total_commas += (n - divisor + 1)

            # Move to next comma level
            divisor *= 1000
        return total_commas

# #  class Solution:
#     def countCommas(self, n: int) -> int:
#         total_commas = 0
#         divisor = 1000
        
#         while n >= divisor:
#             total_commas += (n - divisor + 1)
#             divisor *= 1000
#         return total_commas
        

sol = Solution()
inputs = [1002, 998, 1000]
for s in inputs:
    print(f"Input: s = \"{s}\"")
    print(f"Output: {sol.countCommas(s)}\n")