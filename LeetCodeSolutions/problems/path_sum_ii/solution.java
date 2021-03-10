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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> currentResult = new ArrayList<>();
        pathSum(root, targetSum, currentResult, result);
        return result;
    }
    
    public void pathSum(TreeNode root, int targetSum, List<Integer> currentResult, List<List<Integer>> result) {
        
        if(root == null) {
            return;
        }
        currentResult.add(root.val);
        
        if(root.val == targetSum && root.left==null && root.right==null) {
            result.add(new ArrayList<>(currentResult));
        } else {
            pathSum(root.left, targetSum - root.val, currentResult, result);
            pathSum(root.right, targetSum - root.val, currentResult, result);
        }
        
        currentResult.remove(currentResult.size()-1);
    }
}