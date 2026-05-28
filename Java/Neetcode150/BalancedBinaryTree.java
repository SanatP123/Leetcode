

public class BalancedBinaryTree {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

    public int height(TreeNode node){
        // An empty tree has height -1
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public boolean isBalanced(TreeNode root) {
        // An empty tree satisfies the definition of a balanced tree
        if (root == null){
            return true;
        }

        // Check if subtrees have height within 1. If they do, check if the subtrees are balanced
        if (Math.abs(height(root.left) - height(root.right)) > 1){
            return false;
        }

        return (isBalanced(root.left) && isBalanced(root.right));

        
    }

    public static void main(String[] args) {
        BalancedBinaryTree solution = new BalancedBinaryTree();
        TreeNode root = solution.new TreeNode(3);
        root.left = solution.new TreeNode(9);
        root.right = solution.new TreeNode(20);
        root.right.left = solution.new TreeNode(15);
        root.right.right = solution.new TreeNode(7);

        boolean result = solution.isBalanced(root);
        System.out.println("Is the binary tree balanced? " + result);

        BalancedBinaryTree solution2 = new BalancedBinaryTree();
        TreeNode root2 = solution2.new TreeNode(1);
        root2.left = solution2.new TreeNode(2);
        root2.right = solution2.new TreeNode(2);
        root2.left.left = solution2.new TreeNode(3);
        root2.left.right = solution2.new TreeNode(3);
        root2.left.left.left = solution2.new TreeNode(4);
        root2.left.left.right = solution2.new TreeNode(4);

        boolean result2 = solution2.isBalanced(root2);
        System.out.println("Is the binary tree balanced? " + result2);

    }
}
