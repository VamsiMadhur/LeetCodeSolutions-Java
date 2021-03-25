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
    
     private int result = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        sumNumbers(root, 0);
        return result;
    }
    
    public void sumNumbers(TreeNode root, int sum) {
        if(root == null) {
            return;
        }
        sum = (sum*10) + root.val;
        if(root.left==null && root.right==null) {
            result += sum;
            return;
        }
        
        sumNumbers(root.left, sum);  
        sumNumbers(root.right, sum);
    }
}