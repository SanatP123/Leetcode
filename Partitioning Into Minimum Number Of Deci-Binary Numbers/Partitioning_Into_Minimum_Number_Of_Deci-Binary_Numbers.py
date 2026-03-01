class Solution:
    def minPartitions(self, n: str) -> int:
        # need a minimum of x moves to sum up to number, 
        # where x is the number largest digit in the string
        # but at any one of the moves, if the digit of the current sum has already reached
        # the target digit in the number, we can just switch it to 0
        # hence, the number of moves needed is exactly
        # the largest digit in the string
        return int(max(n))

s = Solution()
inputs = ["32","82734","27346209830709182346"] # 3,8,9]
for i in inputs:
    print(s.minPartitions(i))