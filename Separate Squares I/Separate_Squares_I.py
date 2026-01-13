from typing import List

class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        # Compute total area of all squares
        total_area = sum(l * l for _, _, l in squares)
        # Area below will be exactly half of total area
        target = total_area/2.0

        # Helper function to compute area BELOW a given Y
        def check(Y):
            area = 0
            for x,y,l in squares:
                if y < Y:
                    area += l * min(Y-y,l)
            return area
        
        # Binary search boundaries
        low = min(y for _, y, _ in squares)
        high = max(y + l for _, y, l in squares)

        # Binary search for the correct Y
        while high - low > 1e-5:
            mid = (low + high)/2
            if check(mid) < target:
                low = mid
            else:
                high = mid
        
        return low
    


sol = Solution()

squares = [[0,0,1],[2,2,1]]
result = sol.separateSquares(squares)
print(f"The Y-coordinate that separates the squares into two equal areas is: {result}")

