from collections import deque
from typing import Optional, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# Helper function to build tree from list input
def build_tree(values: List[Optional[int]]) -> Optional[TreeNode]:
    if not values or values[0] is None:
        return None

    root = TreeNode(values[0])
    queue = deque([root])
    i = 1

    while queue and i < len(values):
        node = queue.popleft()

        if i < len(values) and values[i] is not None:
            node.left = TreeNode(values[i])
            queue.append(node.left)
        i += 1

        if i < len(values) and values[i] is not None:
            node.right = TreeNode(values[i])
            queue.append(node.right)
        i += 1

    return root


class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        queue = deque([root])
        max_sum = float('-inf')
        ans_level = 1
        curr_level = 1

        while queue:
            levels = len(queue)
            curr_sum = 0

            for _ in range(levels):
                current_node = queue.popleft()
                curr_sum += current_node.val

                if current_node.left:
                    queue.append(current_node.left)
                if current_node.right:
                    queue.append(current_node.right)

            if curr_sum > max_sum:
                max_sum = curr_sum
                ans_level = curr_level

            curr_level += 1

        return ans_level


# ------------------ TEST CASES ------------------

s = Solution()

test_cases = [
    [1, 7, 0, 7, -8, None, None],
    [989, None, 10250, 98693, -89388, None, None, None, -32127]
]

for case in test_cases:
    root = build_tree(case)
    print(f"Input: {case}")
    print(f"Output: {s.maxLevelSum(root)}\n")
