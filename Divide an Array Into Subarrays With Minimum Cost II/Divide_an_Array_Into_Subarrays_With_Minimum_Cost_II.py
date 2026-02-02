
from typing import List

from sortedcontainers import SortedList

class Solution:
    def minimumCost(self, nums: List[int], k: int, dist: int) -> int:
        
        # Reduce k
        k -= 2
        cost = nums.pop(0)
        res = float("inf")
         # Create a sorted window of the first 'dist' elements
        window = SortedList(nums[:dist])
        cost += sum(window[:k])

        for left,right in zip(nums,nums[dist:]):
            # Add the new element to the sorted window
            window.add(right)
        # If 'right' belongs to the smallest k elements, it should contribute to the cost
            cost += min(window[k], right)

            res = min(res,cost)
             # Remove the effect of 'left' if it was contributing
            cost -= min(window[k], left)
            # Remove the outgoing element from the window
            window.remove(left)

        return res        
    

s = Solution()
inputs = [([1,3,2,6,4,2], 3, 3), ([5,3,2,6,1,4], 2, 3), ([10,1,2,7,1,3], 4, 4)]
for nums, k, dist in inputs:
    print(f"Input: nums = {nums}, k = {k}, dist = {dist}")
    print(f"Output: {s.minimumCost(nums, k, dist)}\n")
