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
    int target = 0;
    public boolean checkEqualTree(TreeNode root) {
        getSumOfAllNodes(root);
        if(target%2 == 0) {
            target /= 2;
            int result = parseTree(root.left);
            if(result == -1000000) return true;
            
            return parseTree(root.right) == -1000000;
        }
        return false;
    }
    
    public int parseTree(TreeNode root) {
        if(root == null) return 0;
        
        int leftTreeVal = 0, rightTreeVal = 0;
        leftTreeVal = parseTree(root.left);
        if(leftTreeVal == -1000000) return -1000000;
        
        rightTreeVal = parseTree(root.right);
        if(rightTreeVal == -1000000) return -1000000;
        
        int currSum = leftTreeVal + rightTreeVal+ root.val;
        if(currSum == target)  return -1000000;
        
        return currSum;
    }
    
    public void getSumOfAllNodes(TreeNode root) {
        if(root == null) return;
        getSumOfAllNodes(root.left);
        target += root.val;
        getSumOfAllNodes(root.right);
    }
}