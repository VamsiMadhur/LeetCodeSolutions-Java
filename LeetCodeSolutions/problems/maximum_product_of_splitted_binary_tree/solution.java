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
    
    private long maximumProduct = 0;
    private int totalTreeSum = 0;
    
    private int treeSum(TreeNode root) {
        if(root == null) return 0;
        return treeSum(root.left) + treeSum(root.right) + root.val;
    }
    
    private int findMaximumProduct(TreeNode subroot) {
        if(subroot == null) return 0;
        int leftSum = findMaximumProduct(subroot.left);
        int rightSum = findMaximumProduct(subroot.right);
        int totalSum = leftSum + rightSum + subroot.val;
        
        long product = (long) totalSum * (totalTreeSum - totalSum);
        this.maximumProduct = Math.max(this.maximumProduct, product);
        
        return totalSum;
    }
    
    public int maxProduct(TreeNode root) {
        this.totalTreeSum = treeSum(root);
        findMaximumProduct(root);
        return (int)(maximumProduct%1000000007);
    }
}