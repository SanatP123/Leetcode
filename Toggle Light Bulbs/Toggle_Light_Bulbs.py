class Solution:
    def toggleLightBulbs(self, bulbs: list[int]) -> list[int]:
        # Set to store the bulbs that are currently on
        s = set()

        for b in bulbs:
            # If the bulb is already on, toggle it off by removing it from the set
            if b in s:
                s.remove(b)
            # If the bulb is off, toggle it on by adding it to the set
            else:
                s.add(b)
        
        # Convert the set of bulbs that are on to a sorted list and return it
        res = sorted(list(s))
        return res

sol = Solution()
inputs = [[10,30,20,10],[100,100],[98,54,6,34,66,63,52,39,62,46,75,28,65,18,37]]
for bulbs in inputs:
    print(f"Input: bulbs = {bulbs}")
    print(f"Output: {sol.toggleLightBulbs(bulbs)}\n")