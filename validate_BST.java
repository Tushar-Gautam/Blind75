/*      Leetcode-98
Q-Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

->The left subtree of a node contains only nodes with keys less than the node's key.
->The right subtree of a node contains only nodes with keys greater than the node's key.
->Both the left and right subtrees must also be binary search trees.

Example 1:
                    5
                   / \
                  1   4
                     / \
                    3  6  

    Input: root = [5,1,4,null,null,3,6]
    Output: false
    Explanation: The root node's value is 5 but its right child's value is 4.

    
 Constraints:
    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1   
 */
//Solution-
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
    public boolean isValidBST(TreeNode root) {
       return check(root,Long.MIN_VALUE, Long.MAX_VALUE); 
    }
    public boolean check(TreeNode root,long min,long max){
        if(root==null){
            return true;
        }
        if(root.val>=max || root.val<=min){
            return false;
        }
        if(check(root.left,min,root.val) && check(root.right,root.val,max)){
            return true;
        }
        return false;
    }
}