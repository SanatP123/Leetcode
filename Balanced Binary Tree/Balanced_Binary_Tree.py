from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        def dfs(node):
            if not node:
                return 0

            # Compute left height
            left = dfs(node.left)
            if left == -1: return -1

            # Compute right height
            right = dfs(node.right)
            if right == -1: return -1

            # If height difference is more than 1, it's unbalanced
            if abs(left - right) > 1:
                return -1

            # Return height of current subtree
            return max(left,right) + 1

        return dfs(root) != -1



sol = Solution()
# Example 1
root1 = TreeNode(3)
root1.left = TreeNode(9)
root1.right = TreeNode(20)
root1.right.left = TreeNode(15)
root1.right.right = TreeNode(7) 
print(f"Input: root = [3,9,20,null,null,15,7]")
print(f"Output: {sol.isBalanced(root1)}\n")

# Example 2
root2 = TreeNode(1)
root2.left = TreeNode(2)
root2.right = TreeNode(2)
root2.left.left = TreeNode(3)
root2.left.right = TreeNode(3)
root2.left.left.left = TreeNode(4)
root2.left.left.right = TreeNode(4)
print(f"Input: root = [1,2,2,3,3,null,null,4,4]")
print(f"Output: {sol.isBalanced(root2)}\n")

# Example 3
root3 = TreeNode(1)
root3.left = TreeNode(2)
root3.right = TreeNode(2)
root3.left.left = TreeNode(3)
print(f"Input: root = [1,2,2,3,null,null,null]")
print(f"Output: {sol.isBalanced(root3)}\n") 

root4 = TreeNode()
print(f"Input: root = []")
print(f"Output: {sol.isBalanced(root4)}\n")