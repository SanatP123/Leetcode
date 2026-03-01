class Solution:
    def trimTrailingVowels(self, s: str) -> str:
        vowels = "aeiou"
        right = len(s)

        while right > 0 and s[right - 1] in vowels:
            # Move left past trailing vowels
            right -= 1
            
        
        return s[:right]

sol = Solution()
inputs = ["idea", "day", "aeiou"] # "id", "day", ""
for s in inputs:
    print(f"Input: s = \"{s}\"")
    print(f"Output: \"{sol.trimTrailingVowels(s)}\"\n")