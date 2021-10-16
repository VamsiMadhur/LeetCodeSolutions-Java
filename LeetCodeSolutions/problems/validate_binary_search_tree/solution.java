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
    boolean result = true;
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        inorder(root);
        return result;
    }
    
    public void inorder(TreeNode root) {
        if(!result) return;
        
        if(root == null) return;
        inorder(root.left);
        
        if(prev!=null && prev.intValue() >= root.val) {
            result = false;
            return;
        }
        
        if(!result) return;
        prev = root.val;
        inorder(root.right);
        return ;
    }
}