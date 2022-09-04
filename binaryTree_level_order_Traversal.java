/*      Leetcode-102
Q-Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
    Example 1:
                    3
                   /  \
                  9   20  
                     /  \
                    15  7   

    Input: root = [3,9,20,null,null,15,7]
    Output: [[3],[9,20],[15,7]]
 
Example 3:
    Input: root = []
    Output: []
 
Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root==null){
            return ans;
        }
        
        Queue<TreeNode> orderTraversal = new ArrayDeque<>();
        orderTraversal.add(root);
        
        while(!orderTraversal.isEmpty()){
            int size = orderTraversal.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = orderTraversal.poll();
                
                list.add(curr.val);
                if(curr.left!=null){
                    orderTraversal.add(curr.left);
                }
                if(curr.right!=null){
                    orderTraversal.add(curr.right);
                }
            }
             ans.add(list);
        }
        return ans;
    }
}