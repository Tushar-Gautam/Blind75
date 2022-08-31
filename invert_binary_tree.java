/*          Leetcode - 226
 Q-Given the root of a binary tree, invert the tree, and return its root.

 Example 2:
Input: root = [2,1,3]
        2
      /   \
     1     3  

Output: [2,3,1]
            2
           / \
          3   1
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

//  Solution-
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//Tc-O(N)
//SC-O(N)
class Solution {
    
    public TreeNode invertTree(TreeNode root) {
       
        if(root==null){
            return root;
        }
         TreeNode head = new TreeNode(root.val);
        
        head.left = (invertTree(root.right));
        head.right = (invertTree(root.left));
        return head;
    }
}

//TC-O(N)
//SC-O(1)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp = root.left; //temp used for swapping
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}

//Iterative 
// Using level order traversal
class Solution {
    public TreeNode invertTree(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while (!queue.isEmpty()) {
             TreeNode node = queue.poll();
             if (node != null) {
                 queue.add(node.left);
                 queue.add(node.right);
                 TreeNode tmp = node.left;
                 node.left = node.right;
                 node.right = tmp;
             }
         }
         return root;
    }
}