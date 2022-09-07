/*      Leetcode-105
Q-Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Constraints:

    1 <= preorder.length <= 3000
    inorder.length == preorder.length
    -3000 <= preorder[i], inorder[i] <= 3000
    preorder and inorder consist of unique values.
    Each value of inorder also appears in preorder.
    preorder is guaranteed to be the preorder traversal of the tree.
    inorder is guaranteed to be the inorder traversal of the tree.
 
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0){
            return null;
        }        
        return constructBT(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    //psi->preorder starting indx
    //pei->preorder ending idx
    //isi->inorder starting indx
    //iei->inorder ending index
    public TreeNode constructBT(int[] preorder,int psi,int pei,int[] inorder,int isi,int iei ){
        if(isi>iei){
            return null;
        }
        
        int idx = isi;
        while(inorder[idx] != preorder[psi]){
            idx++;
        }
        int colse = idx-isi;        //count of left sub elements i.e. the no. elements in the left subtree 
        TreeNode node = new TreeNode(preorder[psi]);
        
        node.left = constructBT(preorder,psi+1,psi+colse,inorder,isi,idx-1);
        node.right = constructBT(preorder,psi+colse+1,pei,inorder,idx+1,iei);
        
        return node;
    }
}