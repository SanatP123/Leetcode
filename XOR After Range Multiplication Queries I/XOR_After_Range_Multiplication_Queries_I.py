
from typing import List

class Solution:
    def xorAfterQueries(self, nums: List[int], queries: List[List[int]]) -> int:
        
        for l,r,k,v in queries:
            idx = l
            while idx <= r:
                nums[idx] = (nums[idx] * v) % (10**9 + 7)
                idx += k
        
        ans = 0
        for num in nums:
            ans = ans ^ num
        
        return ans


s = Solution()
input_nums = [[1,1,1], [2,3,1,5,4]]
input_queries = [[[0,2,1,4]], [[1,4,2,3],[0,2,1,2]]]
for nums, queries in zip(input_nums, input_queries):
    result = s.xorAfterQueries(nums, queries)
    print("Result:", result)