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
    double diff = 2000000001;
    int nodevalue = 0;
    public int closestValue(TreeNode root, double target) {
        if(root == null) return nodevalue;
        if(root.val < target) {
            if(diff > target - root.val) {
                diff = target - root.val;
                nodevalue = root.val;
            }
            return closestValue(root.right, target);
        } else {
            if(diff > root.val - target) {
                diff = root.val - target;
                nodevalue = root.val;
            }
            return closestValue(root.left, target);
        }
        
    }
}