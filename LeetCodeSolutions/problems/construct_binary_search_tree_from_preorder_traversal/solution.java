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
    int idx = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode bst(int[] preorder, int low, int high) {
        if(idx >= preorder.length || preorder[idx] < low || preorder[idx] > high)
            return null;
        
        int rootVal = preorder[idx++];
        TreeNode root = new TreeNode(rootVal);
        root.left = bst(preorder, low, rootVal-1);
        root.right = bst(preorder, rootVal+1, high);
        return root;
    }
}