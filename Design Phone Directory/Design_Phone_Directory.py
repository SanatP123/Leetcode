from collections import deque

class PhoneDirectory:

    def __init__(self, maxNumbers: int):
        # Queue to store all available phone numbers
        self.available = deque()
        
        # Set to keep track of numbers that are currently assigned (in use)
        self.used = set()
        
        # Populate the queue with all available numbers
        for num in range(maxNumbers):
            self.available.append(num)
        

    def get(self) -> int:
        # If no numbers are available, return -1
        if not self.available:
            return -1
        
        # Get the next available number from the front of the queue
        num = self.available.popleft()
        
        # Mark this number as used
        self.used.add(num)
        
        # Return the assigned number
        return num
        

    def check(self, number: int) -> bool:
        # Return True if the number is NOT in use (i.e., available)
        return number not in self.used


    def release(self, number: int) -> None:
        # Only release the number if it is currently assigned
        if number in self.used:
            # Remove it from the used set
            self.used.remove(number)
            
            # Add it back to the available queue for reuse
            self.available.append(number)
        

# Your PhoneDirectory object will be instantiated and called as such:
# obj = PhoneDirectory(maxNumbers)
# param_1 = obj.get()
# param_2 = obj.check(number)
# obj.release(number)

if __name__ == "__main__":
    commands = ["PhoneDirectory", "get", "get", "check", "get", "check", "release", "check"]
    args = [[3], [], [], [2], [], [2], [2], [2]]

    obj = None
    outputs = []

    for cmd, arg in zip(commands, args):
        if cmd == "PhoneDirectory":
            obj = PhoneDirectory(*arg)
            outputs.append(None)
        elif cmd == "get":
            outputs.append(obj.get())
        elif cmd == "check":
            outputs.append(obj.check(*arg))
        elif cmd == "release":
            outputs.append(obj.release(*arg))

    print(outputs)

