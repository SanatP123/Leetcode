class Solution:
    def decodeCiphertext(self, encodedText: str, rows: int) -> str:
        # As the matrix is fully filled
        cols = len(encodedText)//rows
        matrix = [['' for _ in range(cols)] for _ in range(rows)]
        original_text = ""
        
        # Fill the matrix with the encoded Text
        for r in range(rows):
            for c in range(cols):
                # Since encodedText is formed row-wise
                matrix[r][c] = encodedText[r * cols + c]
        
        # Decode by Diagonal Traversal
        for start in range(cols):
            r = 0
            c = start
            while r < rows and c < cols:
                original_text += matrix[r][c]
                r += 1
                c += 1
                
        # Remove Trailing Spaces
        return original_text.rstrip()

sol = Solution()
inputs = [("ch   ie   pr", 3), ("iveo    eed   l te   olc", 4), ("coding", 1)]
for encodedText, rows in inputs:
    print(f"Input: encodedText = \"{encodedText}\", rows = {rows}")
    print(f"Output: \"{sol.decodeCiphertext(encodedText, rows)}\"\n")