from collections import Counter
class Solution:
    def mirrorFrequency(self, s: str) -> int:
        freq_map = Counter(s)

        # Set to track (c,m) and (m,c)
        visited = set()

        ans = 0

        # Returns the mirror of a character
        def mirror(m):
            if m.isalpha():
                return chr(ord('z') - (ord(m) - ord('a')))
            else:
                return chr(ord('9') - (ord(m) - ord('0')))

        # Check every distinct character of the string
        for i,j in freq_map.items():
            
            c = i
            # Mirror of a character
            m = mirror(c)

            # If c is already processed, skip
            if c in visited:
                continue
            else:
                # Absolute Difference between frequencies
                ans += abs(j - freq_map[m])
                # Add the processed characters and mirrors in the visited set
                visited.add(c)
                visited.add(m)
        
        return ans




sol = Solution()
inputs = ["ab1z9", "4m7n", "byby"]
for s in inputs:    
    print(f"Input: s = \"{s}\"")
    print(f"Output: {sol.mirrorFrequency(s)}\n")