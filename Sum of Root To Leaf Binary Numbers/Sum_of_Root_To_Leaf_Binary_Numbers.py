from collections import deque
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        # Priority Queue for BFS Traversal
        pq = deque([(root, 0)])
        total = 0

        while pq:
            
            node,current = pq.popleft()
            # Build binary number
            current = current * 2 + node.val

            # If it's a leaf, add to total
            if not node.left and not node.right:
                total += current

            # Add children to queue
            if node.left:
                pq.append((node.left,current))
            if node.right:
                pq.append((node.right,current))
        
        return total

s = Solution()

# Example 1  -> [1,0,1,0,1,0,1]
root1 = TreeNode(1)
root1.left = TreeNode(0)
root1.right = TreeNode(1)
root1.left.left = TreeNode(0)
root1.left.right = TreeNode(1)
root1.right.left = TreeNode(0)
root1.right.right = TreeNode(1)
print(f"Output: {s.sumRootToLeaf(root1)}")

# Example 2
root2 = TreeNode(0)
print(f"Output: {s.sumRootToLeaf(root2)}")  # Output: 0