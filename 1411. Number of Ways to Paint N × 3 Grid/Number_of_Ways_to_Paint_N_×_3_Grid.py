
class Solution:
    def numOfWays(self, n: int) -> int:
        '''
        2-Colour Patterns : (ABA Pattern - 2 Colours Used)
        ABA, BAB, 
        CBC, BCB, 
        CAC, ACA

        3-Colour Patterns : (ABC Pattern - 3 Colours Used)
        ABC, CBA,
        BAC, BCA,
        ACB, CAB

        Patterns - 
        2-colour → 3 two-colour + 2 three-colour
        3-colour → 2 two-colour + 2 three-colour

        '''
        # Base Case : Row 1 has 6 two-colour and 6 three-colour patterns
        two_colour = 6
        three_colour = 6

        MOD = 10**9 + 7

        for row in range(2,n+1):
            new_two_colour = (three_colour * 2 + two_colour * 3) % MOD
            new_three_colour = (three_colour * 2 + two_colour * 2) % MOD

            two_colour = new_two_colour
            three_colour = new_three_colour
        
        return (two_colour + three_colour) % MOD
    

s = Solution()
# Test cases

inputs = [1, 2, 3, 7, 5000]

for n in inputs:
    print(f"Input: n = {n}")
    output = s.numOfWays(n)
    print(f"Output: {output}\n")