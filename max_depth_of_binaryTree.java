/*      Leetcode-104
Q-Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
            3
           / \
          9   20
             /  \
            15   7  

Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100 
 */
// Solution-
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


//Recursive 
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.right),maxDepth(root.left));
    }
}

//Iterative

class Solution {
    public int maxDepth(TreeNode root) {
     
        Queue<TreeNode> q = new ArrayDeque<>();
        int level=0;
        if(root==null){
            return level;
        }
        
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size(); 
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    q.offer(curr.left);       
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
               
            }
             level++;
        }
        return level;
    }
}