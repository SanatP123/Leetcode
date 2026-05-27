import java.util.Arrays;
public class InvertBinaryTree {

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
 
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree solution = new InvertBinaryTree();
        TreeNode root = solution.new TreeNode(4);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(7);
        root.left.left = solution.new TreeNode(1);
        root.left.right = solution.new TreeNode(3);
        root.right.left = solution.new TreeNode(6);
        root.right.right = solution.new TreeNode(9);

        TreeNode invertedRoot = solution.invertTree(root);

        int[] res = new int[7];
        res[0] = invertedRoot.val;
        res[1] = invertedRoot.left.val;
        res[2] = invertedRoot.right.val;
        res[3] = invertedRoot.left.left.val;        
        res[4] = invertedRoot.left.right.val;
        res[5] = invertedRoot.right.left.val;
        res[6] = invertedRoot.right.right.val;
        System.out.println("Inverted binary tree values: " + Arrays.toString(res));

    }
} 
    

