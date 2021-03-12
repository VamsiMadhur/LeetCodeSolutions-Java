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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        
        TreeNode node = root;
        while(node!=null) {
            if(node.left == null) {
                result.add(node.val);
                node = node.right;
            } else {
                TreeNode predecessor = node.left;
                while((predecessor.right != null) && (predecessor.right != node)) {
                    predecessor = predecessor.right;
                }
                
                if(predecessor.right == null) {
                    result.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                } else {
                    predecessor.right = null;
                    node = node.right;
                }
            }
         
        }
        return result;
    }
    
}