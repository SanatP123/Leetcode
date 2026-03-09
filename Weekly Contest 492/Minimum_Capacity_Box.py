class Solution:
    def minimumIndex(self, capacity: list[int], itemSize: int) -> int:
        # [smallest valid capacity found, its index]
        res = [float("inf"),-1]

        for i,cap in enumerate(capacity):
            # Update if this is the smallest valid capacity so far
            if cap >= itemSize:
                if cap < res[0]:
                    res[0] = cap
                    res[1] = i

        return res[1]

sol = Solution()
inputs = [([1,5,3,7], 3), ([3,5,4,3], 2), ([4], 5)] # 2, 0, -1
for capacity, itemSize in inputs:
    print(f"Input: capacity = {capacity}, itemSize = {itemSize}")
    print(f"Output: {sol.minimumIndex(capacity, itemSize)}\n")