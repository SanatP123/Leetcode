
from typing import List

from itertools import combinations, permutations

class Solution:
    def wordSquares(self, words: List[str]) -> List[List[str]]:
        res = []
        n = len(words)

        for group in combinations(words,4):
            for top, left, right, bottom in permutations(group):
                if (
                    top[0] == left[0] and
                    top[3] == right[0] and
                    bottom[0] == left[3] and
                    bottom[3] == right[3]
                ):
                    res.append([top, left, right, bottom])

        res.sort()
        return res


s = Solution()

# Updated test cases based on the examples provided

inputs = [["able","area","echo","also"],["code","cafe","eden","edge"]]

# Running the test cases

for words in inputs:
    print(f"Input: words = {words}")
    print(f"Output: {s.wordSquares(words)}\n")