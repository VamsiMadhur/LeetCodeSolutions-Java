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
    List<TreeNode> allNodes = new ArrayList<TreeNode>();
    
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return generateBST(0, allNodes.size()-1);
    }
    
    public TreeNode generateBST(int low, int high) {
        if(low > high) return null;
        if(low == high) {
            TreeNode child = allNodes.get(low);
            child.left = null;
            child.right = null;
            return child;
        }
        
        int mid = low + (high-low)/2;
        TreeNode root = allNodes.get(mid);
        root.left = generateBST(low, mid-1);
        root.right = generateBST(mid+1, high);
        return root;
    }
    
    public void inorder(TreeNode root) {
        if(root == null) return;
        
        inorder(root.left);
        allNodes.add(root);
        inorder(root.right);
    }
}