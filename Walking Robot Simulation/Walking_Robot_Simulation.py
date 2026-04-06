from typing import List

class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        # directions: N, E, S, W
        dirs = [(0,1), (1,0), (0,-1), (-1,0)]
        # start facing North
        d = 0
        x, y = 0, 0
        total_distance = 0
        
        # convert obstacles for O(1) lookup
        obstacles = set(map(tuple, obstacles))

        for c in commands:
            if c == -1:
                # turn right
                d = (d + 1) % 4

            elif c == -2:
                # turn left
                d = (d - 1) % 4
    
            else:
                dx,dy = dirs[d]

                # move step-by-step to handle obstacles
                for _ in range(c):
                    nx, ny = dx + x, dy + y
                    if (nx, ny) in obstacles:
                        break

                    x,y = nx,ny
                
                # update max distance
                total_distance = max(total_distance, (x**2 + y**2))
        
        return total_distance



sol = Solution()
inputs = [([4,-1,3], []), ([4,-1,4,-2,4], [[2,4]]), ([6,-1,-1,6], [[3,2],[4,2],[5,2]])]
for commands, obstacles in inputs:
    print(f"Input: commands = {commands}, obstacles = {obstacles}")
    print(f"Output: {sol.robotSim(commands, obstacles)}\n")