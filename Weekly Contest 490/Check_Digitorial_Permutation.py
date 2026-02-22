from itertools import permutations
class Solution:
    def isDigitorialPermutation(self, n: int) -> bool:
        def fact(num):
            res = 1
            if num == 1 or num == 0:
                return res
            for i in range(1,num):
                res += res * i
            return res
        
        total_sum = 0
        str_n = str(n)

        for dig in str_n:
            total_sum += fact(int(dig))

        # check = ["".join(p) for p in permutations(str_n)]

        
        # if str(total_sum) in check:
        #     return True
        # return False
        
        
        return sorted(str(total_sum)) == sorted(str_n)
        
        
sol = Solution()

inputs = [10, 145, 40558, 62227952]
for n in inputs:
    print(f"Input: n = {n}")
    print(f"Output: {sol.isDigitorialPermutation(n)}\n")

