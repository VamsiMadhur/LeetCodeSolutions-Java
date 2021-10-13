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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        
        while(size != 0) {
            List<Integer> currLevel = new ArrayList<>();
            int nextSize = 0;
            
            for(int i=0; i<size; i++) {
                TreeNode temp = queue.poll();
                currLevel.add(temp.val);
                if(temp.left!=null) {
                    queue.offer(temp.left);
                    nextSize++;
                }
                if(temp.right!=null) {
                    queue.offer(temp.right);
                    nextSize++;
                }
            }
            result.add(currLevel);
            size = nextSize;
        }
        return result;
        
    }
}