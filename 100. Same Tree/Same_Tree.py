from typing import Optional

# Definition for a binary tree node.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q:
            return True
        
        if not p or not q:
            return False
        
        if p.val != q.val:
            return False
        
        left = self.isSameTree(p.left,q.left)
        right = self.isSameTree(p.right, q.right)
        
        return left and right
    


sol = Solution()

# Example usage:
# Constructing two binary trees:
# Tree 1:
#         1
#        / \
#       2   3
#

# Tree 2:
#         1
#        / \
#       2   3           

p = TreeNode(1)
p.left = TreeNode(2)
p.right = TreeNode(3)
q = TreeNode(1)
q.left = TreeNode(2)
q.right = TreeNode(3)

result = sol.isSameTree(p, q)
print(f"The two trees are the same: {result}")

