from typing import List
class Robot:

    def __init__(self, width: int, height: int):
        self.x = 0
        self.y = 0
        self.dir = "East" # Initial direction
        self.width = width
        self.height = height
        

    def step(self, num: int) -> None:
        # Reduce steps using perimeter cycle
        perimeter = 2 * (self.width - 1) + 2 * (self.height - 1)
        num %= perimeter

        if num == 0:
            num = perimeter
        
        # Simulate movement step-by-step
        while num > 0:
            if self.dir == "East":
                # Check if next move stays within right boundary
                if self.x + 1 < self.width:
                    self.x += 1
                    num -= 1
                else:
                    # Turn counterclockwise if boundary hit
                    self.dir = "North"

            elif self.dir == "West":
                if self.x - 1 >= 0:
                    self.x -= 1
                    num -= 1
                else:
                    self.dir = "South"

            elif self.dir == "North":
                if self.y + 1 < self.height:
                    self.y += 1
                    num -= 1
                else:
                    self.dir = "West"
            
            elif self.dir == "South":
                if self.y - 1 >= 0:
                    self.y -= 1
                    num -= 1
                else:
                    self.dir = "East"
            
            

    def getPos(self) -> List[int]:
        # Return current position of robot
        return [self.x,self.y]
        

    def getDir(self) -> str:
        # Return current direction of robot
        return self.dir


# Your Robot object will be instantiated and called as such:
# obj = Robot(width, height)
# obj.step(num)
# param_2 = obj.getPos()
# param_3 = obj.getDir()

def test_robot():
    methods = ["Robot", "step", "step", "getPos", "getDir", "step", "step", "step", "getPos", "getDir"]
    args = [[6, 3], [2], [2], [], [], [2], [1], [4], [], []]
    
    obj = None
    results = []
    for i, method in enumerate(methods):
        if method == "Robot":
            obj = Robot(*args[i])
            results.append(None)
        elif method == "step":
            obj.step(*args[i])
            results.append(None)
        elif method == "getPos":
            results.append(obj.getPos())
        elif method == "getDir":
            results.append(obj.getDir())
    
    print("Test results:", results)

if __name__ == "__main__":
    test_robot()


