
from typing import List
class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        events = []

        # Build events: square enters at y, leaves at y + l
        for x, y, l in squares:
            events.append((y, 1, x, x + l))
            events.append((y + l, -1, x, x + l))

        # Sort events by y
        events.sort()

        xs = []                     # active x-intervals
        prev_y = events[0][0]
        total_area = 0.0
        slabs = []                  # (start_y, height, width)

        # Compute union length of x-intervals
        def union_len(intervals):
            intervals.sort()
            res = 0
            end = -10**30
            for a, b in intervals:
                if a > end:
                    res += b - a
                    end = b
                elif b > end:
                    res += b - end
                    end = b
            return res


        # Sweep line in Y direction
        for y, typ, x1, x2 in events:
            if y > prev_y and xs:
                h = y - prev_y
                w = union_len(xs)
                slabs.append((prev_y, h, w))
                total_area += h * w
        
        # Update active intervals
            if typ == 1:
                xs.append((x1, x2))
            else:
                xs.remove((x1, x2))

            prev_y = y
        
        half = total_area / 2.0
        acc = 0.0

        for y, h, w in slabs:
            slab_area = h * w
            if acc + slab_area >= half:
                # Interpolate inside this slab
                return y + (half - acc) / w
            acc += slab_area

        return 0.0


sol = Solution()
squares = [[0,0,1],[2,2,1]]
result = sol.separateSquares(squares)
print(f"The Y-coordinate that separates the squares into two equal areas is: {result}")

