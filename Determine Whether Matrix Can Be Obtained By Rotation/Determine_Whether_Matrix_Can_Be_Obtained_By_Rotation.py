from typing import List
class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        def rotate(matrix):
            # Rotate 90 degrees clockwise
            return [list(row) for row in zip(*matrix[::-1])]
        
        for _ in range(4):
            if mat == target:
                return True
            
            mat = rotate(mat)
        
        return False
        
sol = Solution()
inputs = [([[0,1],[1,0]], [[1,0],[0,1]]), ([[0,1],[1,1]], [[1,0],[0,1]]), ([[0,0,0],[0,1,0],[1,1,1]], [[1,1,1],[0,1,0],[0,0,0]])]
for mat, target in inputs:
    print(f"Input: mat = {mat}, target = {target}")
    print(f"Output: {sol.findRotation(mat, target)}\n")