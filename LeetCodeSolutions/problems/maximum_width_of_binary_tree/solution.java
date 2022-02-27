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
    
    Map<Integer, Integer> cache;
    int depth = 0;
    int result = 0;
    
    public int widthOfBinaryTree(TreeNode root) {
        cache = new HashMap<>();
        
        traversal(root, 0, 0);
        return result;
        
    }
    
    public void traversal(TreeNode root, int row, int column) {
        if(root == null) return;
        
        cache.putIfAbsent(row, column);
        int left = cache.get(row);
        
        result = Math.max(result, column - left + 1);
        
        traversal(root.left, row+1, 2 * column);
        traversal(root.right, row+1, 2 * column + 1);
        
    }
}