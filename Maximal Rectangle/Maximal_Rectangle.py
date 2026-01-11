

from typing import List
class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])

        heights = [0] * cols
        max_area = 0

        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == "1":
                    heights[j] += 1
                else:
                    heights[j] = 0
            
            stack = []
            extend = heights + [0]

            for idx,h in enumerate(extend):
                while stack and h < extend[stack[-1]]:
                    height = extend[stack.pop()]
                    left = stack[-1] if stack else -1
                    width = idx - left - 1
                    max_area = max(max_area, height * width)
                stack.append(idx)
        
        return max_area


sol = Solution()

matrix = [["1","0","1","0","0"],
          ["1","0","1","1","1"],
          ["1","1","1","1","1"],
          ["1","0","0","1","0"]]    

result = sol.maximalRectangle(matrix)
print(f"The area of the largest rectangle is: {result}")