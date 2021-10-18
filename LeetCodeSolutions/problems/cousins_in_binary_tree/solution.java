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
    int count = 0;
    int dx = 0;
    int dy = 0;
    int recordDepth = -1;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        depth(root, x, y, 0);
        return count==2 && dx==dy;
    }
    
    public void depth(TreeNode root, int x, int y, int depth) {
        if(recordDepth != -1 && depth > recordDepth) return;
        
        if(count >= 2 || root == null) return;
     
        if(root.left != null && root.right!=null) {
            if((root.left.val == x && root.right.val == y) || 
                (root.left.val == y && root.right.val == x)) {
                count = 3;
                return;
            }
        }
        
        if(root.val == x) {
            dx = depth;
            recordDepth = depth;
            count++;
        }
        
        if(root.val == y) {
            dy = depth;
            recordDepth = depth;
            count++;
        }
        depth(root.left, x, y, depth+1);
        depth(root.right, x, y, depth+1);
    }
}