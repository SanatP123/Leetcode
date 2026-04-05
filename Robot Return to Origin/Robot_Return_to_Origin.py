class Solution:
    def judgeCircle(self, moves: str) -> bool:
        cur_x = 0
        cur_y = 0

        for move in moves:
            if move == "U":
                cur_y += 1
            elif move == "D":
                cur_y -= 1
            elif move == "L":
                cur_x -= 1
            else:
                cur_x += 1
        
        return cur_x == 0 and cur_y == 0

sol = Solution()
inputs = ["UD", "LL", "RRDD", "LDRRLRUUL"]
for moves in inputs:
    print(f"Input: moves = \"{moves}\"")
    print(f"Output: {sol.judgeCircle(moves)}\n")