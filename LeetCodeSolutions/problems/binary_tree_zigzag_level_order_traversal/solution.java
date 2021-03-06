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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) {
            return result;
        }
        
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        boolean isLeft = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> tempQueue = new ArrayList<>();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i=size-1; i>=0; i--) {
                TreeNode node = queue.get(i);
                currentLevel.add(node.val);
                if(isLeft) {
                    if(node.left != null) {
                        tempQueue.add(node.left);
                    }
                    if(node.right != null) {
                        tempQueue.add(node.right);
                    }
                } else {
                    if(node.right != null) {
                        tempQueue.add(node.right);
                    }
                    if(node.left != null) {
                        tempQueue.add(node.left);
                    }
                }
            }
            result.add(currentLevel);
            isLeft = !isLeft;
            queue.clear();
            queue.addAll(tempQueue);
        }
        return result;
    }
}