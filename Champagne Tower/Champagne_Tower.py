class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        # Initialize a 2D-array 
        tower = [[0] * (k+1) for k in range(query_row + 1)]
        
        # Pour all champagne into the top glass
        tower[0][0] = poured

        # Iterate row by row until the row before query_row
        for row in range(query_row):
            for glass in range(len(tower[row])):
                excess = (tower[row][glass] - 1.0)/2.0

            # Only distribute if there is overflow
                if excess > 0:
                    tower[row+1][glass] += excess
                    tower[row+1][glass+1] += excess
                    
        # A glass can hold at most 1 cup
        return min(1.0, tower[query_row][query_glass])


sol = Solution()
inputs = [(1,1,1),(2,1,1),(100000009,33,17)]
for poured, query_row, query_glass in inputs:
    print(f"Input: poured = {poured}, query_row = {query_row}, query_glass = {query_glass}")
    print(f"Output: {sol.champagneTower(poured, query_row, query_glass)}\n")