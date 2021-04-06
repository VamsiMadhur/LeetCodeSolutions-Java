/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode node = root;
        TreeNode result = null;
        while(node!=null) {
            if(p.val < node.val) {
                result = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return result;
        
    }
}