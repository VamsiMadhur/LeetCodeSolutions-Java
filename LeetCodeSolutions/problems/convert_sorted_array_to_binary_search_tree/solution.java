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
    public TreeNode sortedArrayToBST(int[] nums) {
        return convertArryToBST(nums, 0, nums.length-1);
    }
    
    public TreeNode convertArryToBST(int[] nums, int low, int high) {
        int length = high-low+1;
        if(length==0) {
            return null;
        }
        if(length==1) {
            return new TreeNode(nums[low]);
        }
        
        int mid = length/2;
        TreeNode result = new TreeNode(nums[low+mid]);
        
        TreeNode leftTree = convertArryToBST(nums, low, low+mid-1);
        TreeNode rightTree = convertArryToBST(nums, low+mid+1, low+length-1);
        result.left = leftTree;
        result.right = rightTree;
        return result;
        
    }
}