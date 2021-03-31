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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int size = 1;
        while(size!=0) {
            int childSize = 0;
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(i==0)
                    result.add(node.val);
                if(node.right!=null) {
                    queue.offer(node.right);
                    childSize++;
                }
                if(node.left!=null) {
                    queue.offer(node.left);
                    childSize++;
                }
            }
            size = childSize;
        }
        return result;
    }
}