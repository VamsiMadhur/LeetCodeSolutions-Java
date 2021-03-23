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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        while(!queue.isEmpty()) {
            long sum = 0;
            int childSize = 0;
            for(int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if(curr.left!=null) {
                    queue.offer(curr.left);
                    childSize++;
                }
                if(curr.right!=null) {
                    queue.offer(curr.right);
                    childSize++;
                }
            }
            result.add((sum*1.0)/size);
            size = childSize;
        }
        return result;
    }
}