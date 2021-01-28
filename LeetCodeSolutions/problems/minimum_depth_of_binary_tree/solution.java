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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queu = new LinkedList<TreeNode>();
        queu.add(root);
        boolean isFinded = false;
        int depth = 0;
        
        while(!isFinded && !queu.isEmpty()) {
            depth++;
            int size = queu.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queu.remove();
                if(node.left == null && node.right==null) {
                    isFinded = true;
                    break;
                }
                if(node.left!=null) {
                    queu.add(node.left);
                }
                if(node.right!=null) {
                    queu.add(node.right);
                }
            }
        }
        return depth;
    }
}