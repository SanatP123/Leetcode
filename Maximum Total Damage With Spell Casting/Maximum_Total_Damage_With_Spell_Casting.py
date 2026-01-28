from typing import List
from collections import Counter
class Solution:
    def maximumTotalDamage(self, power: List[int]) -> int:
        # Count how many times each damage value appears
        count = Counter(power)
        # Sorted list of (damage_value, frequency)
        vec = [(0,0)]
        for k in sorted(count.keys()):
            vec.append((k,count[k]))
        
        n = len(vec)
        # Maximum total damage of a valid sequence
        f = [0] * n

        mx = 0
        j = 0

        for i in range(n):
            # Move j to include all compatible previous values
            while j < i and vec[j][0] < vec[i][0] - 2:
                mx = max(mx,f[j])
                j += 1
             # Take current value and add best compatible total
            f[i] = mx + vec[i][0] * vec[i][1]
        
         # Optimal solution must end at one of the n-3 values
        return max(f[max(0, n - 3):])


sol = Solution()
power = [3, 4, 2, 3, 3, 4, 5]
result = sol.maximumTotalDamage(power)
print(f"The maximum total damage with spell casting for the power levels {power} is: {result}")