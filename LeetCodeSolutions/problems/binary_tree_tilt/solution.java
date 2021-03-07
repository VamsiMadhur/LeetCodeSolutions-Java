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
     public int findTilt(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return findTilt2(root)[1];
    }
    
    public int[] findTilt2(TreeNode root) {
        int[] result = new int[2];
        if(root==null) {
            return result;
        }
        int[] leftSum = findTilt2(root.left);
        int[] rightSum = findTilt2(root.right);
        
        int diff=0;
        if(rightSum[0]>leftSum[0]) {
            diff = (rightSum[0]-leftSum[0]);
        } else {
            diff = (leftSum[0]-rightSum[0]);
        }
        
        result[0] = leftSum[0]+rightSum[0]+root.val;
        result[1] = diff+leftSum[1]+rightSum[1];
        return result;
        
    }
}