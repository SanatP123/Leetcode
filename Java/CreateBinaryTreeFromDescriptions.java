import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions {

//  Definition for a binary tree node.
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
    public TreeNode createBinaryTree(int[][] descriptions) {

        // Map node value -> TreeNode
        Map<Integer, TreeNode> map = new HashMap<>();

        // Track all nodes that appear as children
        Set<Integer> children = new HashSet<>();

        for (int[] description : descriptions){
            int parentValue = description[0];
            int childValue = description[1];
            int isLeft = description[2];

             // Create parent node if it doesn't exist
            if (!map.containsKey(parentValue)){
                map.put(parentValue, new TreeNode(parentValue));
            }

            // Create child node if it doesn't exist
            if (!map.containsKey(childValue)){
                map.put(childValue, new TreeNode(childValue));
            }

              // Connect parent and child
            if (isLeft == 1){
                map.get(parentValue).left = map.get(childValue);
            }
            else{
                map.get(parentValue).right = map.get(childValue);
            }

              // Child cannot be the root
            children.add(childValue);

        }

        // Root is the only node that never appeared as a child
        for(TreeNode node : map.values()){
            if (!children.contains(node.val)){
                return node; // Root found
            }
        }

        return null;
        
    }

    public static void main(String[] args) {
        CreateBinaryTreeFromDescriptions solution = new CreateBinaryTreeFromDescriptions();
        int[][] descriptions = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{17,19,0}};
        TreeNode result = solution.createBinaryTree(descriptions);
        // Output should be : [50,20,80,15,17,19]
        System.out.println("Root of the created binary tree: " + result.val + " " + result.left.val + " " + result.right.val + " " + result.left.left.val + " " + result.left.right.val + " " + result.left.right.right.val);

        CreateBinaryTreeFromDescriptions solution2 = new CreateBinaryTreeFromDescriptions();
        int[][] descriptions2 = {{1,2,1},{2,3,0},{3,4,1}};
        TreeNode result2 = solution2.createBinaryTree(descriptions2);
        // Output should be : [1,2,null,null,3,4]
        System.out.println("Root of the created binary tree: " + result2.val + " " + result2.left.val + " " + (result2.right == null ? "null" : result2.right.val) + " " + (result2.left.left == null ? "null" : result2.left.left.val) + " " + (result2.left.right == null ? "null" : result2.left.right.val) + " " + result2.left.right.left.val);
    
}

}
