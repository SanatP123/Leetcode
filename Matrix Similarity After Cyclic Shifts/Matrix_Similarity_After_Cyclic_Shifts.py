from typing import List
class Solution:
    def areSimilar(self, mat: List[List[int]], k: int) -> bool:
        rows = len(mat)
        cols = len(mat[0])
        
        # Effective shift: shifting by the number of columns brings row back to original
        shift = k % cols

        if shift == 0:
            return True
        
        for i in range(rows):
            for j in range(cols):
                
                # EVEN-indexed row → left shift
                if i % 2 == 0:
                    if mat[i][j] != mat[i][(j + shift) % cols]:
                        return False
                else:
                    # ODD-indexed row → right shift
                    if mat[i][j] != mat[i][(j - shift) % cols]:
                        return False
        
        return True

sol = Solution()
inputs = [[[[1,2,3],[4,5,6],[7,8,9]],4], [[[1,2,1,2],[5,5,5,5],[6,3,6,3]],2], [[[2,2],[2,2]],3]]
for mat, k in inputs:
    print(f"Input: mat = {mat}, k = {k}")
    print(f"Output: {sol.areSimilar(mat, k)}\n")

