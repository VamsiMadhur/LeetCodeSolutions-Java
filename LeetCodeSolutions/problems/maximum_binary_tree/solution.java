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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums, int low, int high) {
        if(low > high) return null;
        if(low == high) return new TreeNode(nums[low]);
        
        int largest = nums[low];
        int largestIndex = low;
        for(int i=low+1; i<=high; i++) {
            if(largest < nums[i]) {
                largest = nums[i];
                largestIndex = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[largestIndex]);
        root.left = constructMaximumBinaryTree(nums, low, largestIndex-1);
        root.right = constructMaximumBinaryTree(nums, largestIndex+1, high);
        return root;
    }
}