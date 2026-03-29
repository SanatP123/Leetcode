class Solution:
    def canBeEqual(self, s1: str, s2: str) -> bool:
        # Extract and sort characters at even indices (0 and 2) for both strings
        even_indices1 = sorted([s1[0],s1[2]])
        even_indices2 = sorted([s2[0],s2[2]])

                # Extract and sort characters at even indices (1 and 3) for both strings
        odd_indices1 = sorted([s1[1],s1[3]])
        odd_indices2 = sorted([s2[1],s2[3]])

        # Return True only if both even groups match and odd groups match
        return even_indices1 == even_indices2 and odd_indices1 == odd_indices2


sol = Solution()
inputs = [["abcd","cdab"], ["dacb","abcd"], ["abab","aabb"]]
for s1, s2 in inputs:
    print(f"Input: s1 = {s1}, s2 = {s2}")
    print(f"Output: {sol.canBeEqual(s1, s2)}\n")