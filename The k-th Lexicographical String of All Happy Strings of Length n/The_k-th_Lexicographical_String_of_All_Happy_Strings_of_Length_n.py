class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        # Store generated happy strings
        res = []

        def dfs(path):

            # Stop early if we already have k strings
            if len(res) >= k:
                return
            
            # If length reached n → valid happy string
            if len(path) == n:
                res.append(path)
                return
            
            # Try characters in lexicographic order
            for ch in 'abc':
                if not path or path[-1] != ch:
                    # Ensure adjacent characters are different
                    dfs(path + ch)
            
        
        dfs("")
        
        return res[k-1] if k <= len(res) else ""

sol = Solution()
inputs = [(1, 3), (1, 4), (3, 9)] # "c", "", "cab"
for n, k in inputs:
    print(f"Input: n = {n}, k = {k}")
    print(f"Output: \"{sol.getHappyString(n, k)}\"\n")