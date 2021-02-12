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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root==null) {
            return result;
        }
        binaryTreePaths(root, "", result);
        return result;
    }
    
    public void binaryTreePaths(TreeNode root, String path, List<String> result) {
        if(root.left == null && root.right==null) {
            if(!path.isEmpty()) {
                path += "->" ;    
            }
            path += String.valueOf(root.val);
            result.add(path);
        } else if(root.left == null) {
             if(!path.isEmpty()) {
                path += "->" ;    
            }
            path += String.valueOf(root.val);
            binaryTreePaths(root.right, path, result);
        } else if(root.right == null) {
             if(!path.isEmpty()) {
                path += "->" ;    
            }
            path += String.valueOf(root.val);
            binaryTreePaths(root.left, path, result);
        } else {
             if(!path.isEmpty()) {
                path += "->" ;    
            }
            path += String.valueOf(root.val);
            binaryTreePaths(root.left, path, result);
            binaryTreePaths(root.right, path, result);
        }
    }
}