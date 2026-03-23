class Solution:
    def uniformArray(self, nums1: list[int]) -> bool:
        
        # If a number is even → we can keep it even
        # If a number is odd → we can convert it:
        # odd - odd = even
        # odd - even = odd

        return True

sol = Solution()
inputs = [[2,3], [4,6], [2,2,7,7]]
for nums1 in inputs:
    print(f"Input: nums1 = {nums1}")
    print(f"Output: {sol.uniformArray(nums1)}\n")