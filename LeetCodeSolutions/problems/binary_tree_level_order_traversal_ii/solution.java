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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> queu = new LinkedList<TreeNode>();
        queu.add(root);
        while(!queu.isEmpty()) {
            List<Integer> currentDepth = new ArrayList<Integer>();
            int size = queu.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queu.remove();
                currentDepth.add(node.val);
                if(node.left!=null) {
                    queu.add(node.left);
                }
                if(node.right!=null) {
                    queu.add(node.right);
                }
            }
            result.addFirst(currentDepth);
        }
        
        return result;
    }
}