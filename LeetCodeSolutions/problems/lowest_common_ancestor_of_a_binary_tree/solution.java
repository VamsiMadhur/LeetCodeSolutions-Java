/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private TreeNode ans = null;
    
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        
        int left = dfs(root.left, p, q) ? 1 : 0;
        int right = dfs(root.right, p, q) ? 1 : 0;
        
        int currentNode = (root == p || root==q) ? 1:0;
        
        if(currentNode+left+right >= 2) {
            this.ans = root;
        }
        
        return (currentNode + left + right > 0);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return this.ans;
    }
    
}