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
    
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }
    
    public int sumRootToLeaf(TreeNode root, int val) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return val + root.val;
        val = 2 * (val + root.val);
        int left = sumRootToLeaf(root.left, val);
        int right = sumRootToLeaf(root.right, val);
        return left+right;
        
    }
}