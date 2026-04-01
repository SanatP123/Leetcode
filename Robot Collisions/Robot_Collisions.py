from typing import List
class Solution:
    def survivedRobotsHealths(self, positions: List[int], healths: List[int], directions: str) -> List[int]:
        # (position, direction, health, original index)
        robots = [(positions[i], directions[i], healths[i], i) for i in range(len(positions))]
        robots.sort()  # process from left → right

        stack = []  # stores [health, direction, index]

        for pos, direction, health, idx in robots:
            if direction == "R":
                # right-moving robots may collide later
                stack.append([health, direction, idx])
            else:
                # collide with previous right-moving robots
                while stack and stack[-1][1] == "R" and health > 0:
                    prev_health, _, _ = stack[-1]

                    if prev_health < health:
                        stack.pop()
                        health -= 1
                    elif prev_health > health:
                        stack[-1][0] -= 1
                        health = 0
                    else:
                        stack.pop()
                        health = 0

                # if still alive, add to stack
                if health > 0:
                    stack.append([health, direction, idx])

        # return survivors in original order
        stack.sort(key=lambda x: x[2])
        return [health for health, _, _ in stack]


sol = Solution()

# Example usage:
positions = [5, 4, 3, 2, 1]
healths = [2, 17, 9, 15, 10]
directions = "RRRRR"
print(sol.survivedRobotsHealths(positions, healths, directions))  # [2, 17, 9, 15, 10]

positions = [3, 5, 2, 6]
healths = [10, 10, 15, 12]
directions = "RLRL"
print(sol.survivedRobotsHealths(positions, healths, directions))  # [14]

positions = [1, 2, 5, 6]
healths = [10, 10, 11, 11]
directions = "RLRL"
print(sol.survivedRobotsHealths(positions, healths, directions))  # []
