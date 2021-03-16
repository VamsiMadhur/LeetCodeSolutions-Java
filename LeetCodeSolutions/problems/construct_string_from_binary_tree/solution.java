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
    
    public String tree2str(TreeNode t) {
        if(t == null) {
            return "";
        }
        StringBuilder  result = new StringBuilder ();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(t);
        TreeNode dummy = new TreeNode(0);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node == dummy) {
                result.append(")");
                continue;
            }
            result.append("(").append(node.val);
            stack.push(dummy);
            
            if(node.left == null && node.right!=null) {
                result.append("()");
                stack.push(node.right);
            } else if(node.left!=null && node.right == null) {
                stack.push(node.left);
            } else if(node.left !=null && node.right!=null) {
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        
        return result.substring(1, result.length()-1);
    }
}