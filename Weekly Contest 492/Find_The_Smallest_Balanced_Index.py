class Solution:
    def smallestBalancedIndex(self, nums: list[int]) -> int:
        n = len(nums)

        if n < 2:
            return -1
        
        # Total sum initially
        l_sum = sum(nums)
        # Product of elements to the right
        r_prod = 1

        for i in range(n-1,-1,-1):
            l_sum -= nums[i]
            if l_sum == r_prod:
                return i
            
            # Early stop since product will only increase further
            if r_prod > l_sum:
                break
            

            r_prod *= nums[i]

        return -1 

sol = Solution()
inputs = [[2,1,2], [2,8,2,2,5], [1]] # 1, 2, -1
for nums in inputs:
    print(f"Input: nums = {nums}")
    print(f"Output: {sol.smallestBalancedIndex(nums)}\n")