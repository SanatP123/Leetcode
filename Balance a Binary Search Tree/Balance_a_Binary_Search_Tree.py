# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        array = []

        def inorder(root):
            if root == None:
                return
            inorder(root.left)
            array.append(root.val)
            inorder(root.right)

        def BST(l, r):
            if l > r:
                return None
            m = (l + r) // 2
            left = BST(l, m - 1)
            right = BST(m + 1, r)
            return TreeNode(array[m], left, right)

        inorder(root)
        return BST(0, len(array) - 1)


def treeToList(node):
    """Convert tree to level-order list representation"""
    if not node:
        return []
    result = []
    queue = [node]
    while queue:
        curr = queue.pop(0)
        if curr:
            result.append(curr.val)
            queue.append(curr.left)
            queue.append(curr.right)
        else:
            result.append(None)
    # Remove trailing nulls
    while result and result[-1] is None:
        result.pop()
    return result


# Test Cases
sol = Solution()


root1 = TreeNode(1)
root1.right = TreeNode(2)
root1.right.right = TreeNode(3)
root1.right.right.right = TreeNode(4)
print(f"Input: root = [1,null,2,null,3,null,4,null,null]")
balanced_root1 = sol.balanceBST(root1)
output1 = treeToList(balanced_root1)
print(f"Output: {output1}")



root2 = TreeNode(2)
root2.left = TreeNode(1)
root2.right = TreeNode(3)
print(f"Input: root = [2,1,3]")
balanced_root2 = sol.balanceBST(root2)
output2 = treeToList(balanced_root2)
print(f"Output: {output2}")

