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
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    
    public int traversal(TreeNode root, List<List<Integer>> result) {
        if(root == null) return -1;
        
        int ld = traversal(root.left, result);
        int rd = traversal(root.right, result);
        
        int currHeight = 1 + Math.max(ld, rd);
        
        if(result.size() == currHeight) {
            result.add(new ArrayList<>());
        }
        
        result.get(currHeight).add(root.val);
        return currHeight;
    }
}