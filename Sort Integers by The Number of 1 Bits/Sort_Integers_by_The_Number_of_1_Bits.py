
from typing import List

class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        # Sort the array in ascending order.
        arr.sort()
        pairs = []
        for num in arr:
             # bit_count() returns the number of 1s in binary form of num
            pairs.append((num,num.bit_count()))
        
        # Sort tuple items based on the bit count (value)
        pairs.sort(key = lambda x:x[1])
        
        return [num for num,_ in pairs]
            
s = Solution()
# Example 1
inputs = [[0,1,2,3,4,5,6,7,8],[1024,512,256,128,64,32,16,8,4,2,1]]
for i, arr in enumerate(inputs):
    print(f"Input: {arr}")
    print(f"Output: {s.sortByBits(arr)}")  # Output
