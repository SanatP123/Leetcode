from typing import List
class Solution:
    def mapWordWeights(self, words: List[str], weights: List[int]) -> str:
         # Create a mapping from numbers 0–25 to letters in reverse order
        maps = {i: chr(ord('z') - i) for i in range(26)}
        res = ""
        for word in words:
            sums = 0
            for w in word:
                # Convert character to index and add corresponding weight
                sums += weights[ord(w) - ord('a')]
            
            mod = sums % 26
            # Use the map to convert the number into a letter
            res += maps[mod]
        
        return res
            


sol = Solution()
inputs = [(["abcd","def","xyz"],[5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2]), (["a","b","c"],[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]), (["abcd"], [7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5]) ]
for words, weights in inputs:
    print(f"Input: words = {words}, weights = {weights}")
    print(f"Output: \"{sol.mapWordWeights(words, weights)}\"\n")

