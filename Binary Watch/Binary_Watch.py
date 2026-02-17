from typing import List
class Solution:
    def readBinaryWatch(self, turnedOn: int) -> List[str]:
        # This list will store all valid time strings
        res = []

        # Loop through all possible hours (0 to 11)
        for hour in range(12):
            # Loop through all possible minutes (0 to 59)

            for minute in range(60):
        # Count how many 1-bits are in the binary representation
                binary_count = bin(hour).count('1') + bin(minute).count('1')

                # If total LEDs turned on equals turnedOn
                if binary_count == turnedOn:
                    result_string = str(hour) + ":"
                    if len(str(minute)) == 2:
                        result_string += str(minute)
                    else:
                        # Add leading zero if required
                        result_string += "0" + str(minute)
                    
                    # Add the formatted time to the result list
                    res.append(result_string)
                

        return res 


sol = Solution()
inputs = [1,9]
for turnedOn in inputs:
    print(f"Input: turnedOn = {turnedOn}")
    print(f"Output: {sol.readBinaryWatch(turnedOn)}\n")