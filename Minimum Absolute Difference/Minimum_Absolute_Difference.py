from typing import List
class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        res = []
        min_diff = float("inf")

        for i in range(1,len(arr)):
            pair_diff = arr[i] - arr[i-1]
            # If the difference is lesser, then reset result list
            if pair_diff < min_diff:
                res = []
                min_diff = pair_diff
                res.append([arr[i-1],arr[i]])
            
            # Found another pair with the same minimum difference
            elif pair_diff == min_diff:
                res.append([arr[i-1],arr[i]])    

        return res    

sol = Solution()
arr = [4,2,1,3]
result = sol.minimumAbsDifference(arr)
print(f"The minimum absolute difference pairs in the array {arr} are: {result}")