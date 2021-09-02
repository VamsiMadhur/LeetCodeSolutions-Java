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

    double average = 0;
    
    public double maximumAverageSubtree(TreeNode root) {
        preOrder(root);
        return average;
    }
    
    public int[] preOrder(TreeNode root) {
        if(root == null) return new int[2];
        
        int[] left = preOrder(root.left);
        int[] right = preOrder(root.right);

        int[] result = new int[2];
        result[0] = left[0] + right[0] + root.val;
        result[1] = left[1] + right[1] + 1;
        average = Math.max(1.0 * result[0]/result[1] , average);
        
        return result;
    }
}