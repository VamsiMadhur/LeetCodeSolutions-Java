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
    
    public int computeDepth(TreeNode root) {
        int depth = 0;
        while(root.left != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
    
    public boolean exists(TreeNode node, int depth, int index) {
        int left=0, right= (1<<depth )-1;
        
        for(int i=0; i<depth; i++) {
            int mid = (left+right)/2;
            if(index<=mid) {
                node = node.left;
                right = mid;
            } else {
                node = node.right;
                left = mid+1;
            }
        }
        return node != null;
    }
    
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int depth = computeDepth(root); //root level is 0
        int noOfNodes = (1<<depth )-1; //count till 0 to depth-1
        
        
        int left=0, right=noOfNodes;
        while(left<=right) {
            int mid = (left+right)/2;
            if(exists(root, depth, mid)) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return noOfNodes+left;
    }
}