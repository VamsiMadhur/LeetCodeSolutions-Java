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
    int maxDepth = 0;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        dfs(root, -1);
        return sum;
    }
    
    public void dfs(TreeNode root, int depth) {
        if(root == null) return;
        
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
        
        if(depth == maxDepth) {
            sum += root.val;
        } else if(depth > maxDepth) {
            sum = root.val;
            maxDepth = depth;
        }
    }
}