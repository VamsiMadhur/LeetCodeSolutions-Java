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
    
    TreeNode prev = null;
    
    boolean result = true;
    
    public boolean isValidBST(TreeNode root) {
         if(root == null) {
             return true;
         }
        isValidBST1(root);
        return result;
    }
    
    public void isValidBST1(TreeNode root) {
        if(!result) {
            return;
        }
        if(root==null) {
            return;
        }
        isValidBST1(root.left);
        
        if(prev != null && prev.val >= root.val) {
            result=false;
            return;
        }
        prev = root;
        
        isValidBST1(root.right);
    }
}