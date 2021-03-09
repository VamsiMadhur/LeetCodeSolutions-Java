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
    
    Map<Integer, Integer> index_map = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         if(postorder==null || postorder.length == 0) {
            return null;
        }
         for(int i=0; i<inorder.length; i++) {
            index_map.put(inorder[i],i);
        }
        return buildTree(postorder, inorder, 0, postorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] postorder,int[] inorder,int ps,int pe, int is, int ie) {
        if(ps > pe || is > ie) {
            return null;
        }
        if(ps == pe) {
            return new TreeNode(postorder[ps]);
        }
        
        int rootval = postorder[pe];
        TreeNode root = new TreeNode(rootval);
        int i = index_map.get(rootval);
        
        root.left = buildTree(postorder, inorder, ps, ps+i-is-1, is, i-1);
        root.right = buildTree(postorder, inorder, ps+i-is, pe-1, i+1, ie);
        return root;
    }
}