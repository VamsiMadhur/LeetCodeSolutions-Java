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
    List<List<Integer>> result = new LinkedList<>();
    
    LinkedList<Integer> path  = new LinkedList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum);
        return result;
    }
    
    public void helper(TreeNode root, int targetSum) {
        if(root == null) return;
        
        if(root.left == null && root.right == null && targetSum == root.val) {
            path.add(root.val);
            result.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        
        path.add(root.val);
        if(root.left != null)
            helper(root.left, targetSum-root.val);
        if(root.right != null)
            helper(root.right, targetSum-root.val);
        path.removeLast();
        
        
    }
}