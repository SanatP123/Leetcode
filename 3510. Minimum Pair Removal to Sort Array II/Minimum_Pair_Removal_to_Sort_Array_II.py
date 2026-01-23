from typing import List
from heapq import heappush, heappop
from math import inf

class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        # prev[i] and nxt[i] simulate a doubly linked list over indices
        prev = [i-1 for i in range(len(nums))]
        nxt = [i+1 for i in range(len(nums))]

        # Sentinel setup to avoid index errors
        prev.append(len(nums) - 1)
        nxt[-1] = -1  # last element has no next
        nxt.append(0)

        # min-heap storing (pair_sum, right_index)
        heap = []
        # number of decreasing adjacent pairs
        bad = 0

        # Initialize heap and count "bad" (decreasing) pairs
        for i in range(1, len(nums)):
            if nums[i-1] > nums[i]:
                bad += 1
            heappush(heap, (nums[i-1] + nums[i], i))
        ans = 0

        while bad:
            sums, r = heappop(heap)

            l = prev[r]
            # Skip stale or invalid heap entries
            if l == -1 or nums[l] + nums[r] != sums:
                continue
            
            nxt[l] = nxt[r]
            prev[nxt[r]] = l

            if nums[l] > nums[r]:
                bad -= 1
            
            ll = prev[l]
            rr = nxt[r]

            # Update bad count and heap for left and right neighbor
            if ll != -1:
                bad += (nums[ll] > sums) - (nums[ll] > nums[l])
                heappush(heap, (nums[ll] + sums, l))
            if rr != -1:
                bad += (sums > nums[rr]) - (nums[r] > nums[rr])
                heappush(heap, (nums[rr] + sums, rr))
            
            # Store merged value at index l
            nums[l] = sums
            nums[r] = inf
            ans += 1
        
        return ans


sol = Solution()
nums = [5,2,3,1]
result = sol.minimumPairRemoval(nums)
print(f"The minimum number of pair removals to sort the array {nums} is: {result}")
