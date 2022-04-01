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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if(key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        
        if(root.left == null) {
            return root.right;
        } else if(root.right == null) {
            return root.left;
        }
        
        TreeNode tempParent = root;
        TreeNode temp = root.right;
        while(temp.left != null) {
            tempParent = temp;
            temp = temp.left;
        }
        if(tempParent != root) {
            tempParent.left = temp.right;
            temp.right = root.right;
        }
        temp.left = root.left;
        return temp;
    }
}