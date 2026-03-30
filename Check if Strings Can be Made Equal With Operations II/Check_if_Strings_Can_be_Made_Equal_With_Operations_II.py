class Solution:
    def checkStrings(self, s1: str, s2: str) -> bool:
        # j-i is even when both j and i are even or both are odd

        # Extract and sort characters at even indices and odd indices
        even_indices1 = []
        even_indices2 = []
        odd_indices1 = []
        odd_indices2 = []

        for i in range(len(s1)):
            if i % 2 == 0:
                even_indices1.append(s1[i])
                even_indices2.append(s2[i])
            else:
                odd_indices1.append(s1[i])
                odd_indices2.append(s2[i])
        
        # If characters at both even and odd indices are equal, then they can be swapped to make the string equal
        return sorted(even_indices1) == sorted(even_indices2) and sorted(odd_indices1) == sorted(odd_indices2)
    
s = Solution()
inputs = [["abcdba","cabdab"],["abe", "bea"]] # true, false 
for s1, s2 in inputs:
    print(f"Input: s1 = {s1}, s2 = {s2}")
    print(f"Output: {s.checkStrings(s1, s2)}\n")