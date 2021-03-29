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
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode node = root;
        TreeNode prevRightNode = null;
        TreeNode prev = null;
        while(node!=null) {
            TreeNode tempLeft = node.left;
            TreeNode tempRight = node.right;
            
            node.left = prevRightNode;
            node.right = prev;
            
            prev = node;
            prevRightNode = tempRight;
            node = tempLeft;
        }
        return prev;
        
    }
}