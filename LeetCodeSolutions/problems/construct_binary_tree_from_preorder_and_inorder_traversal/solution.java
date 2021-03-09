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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length == 0) {
            return null;
        }
        for(int i=0; i<inorder.length; i++) {
            index_map.put(inorder[i],i);
        }
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if(ps > pe || is > ie) {
            return null;
        }
        if(ps == pe) {
            return new TreeNode(preorder[ps]);
        }
        
        int rootval = preorder[ps];
        TreeNode root = new TreeNode(rootval);
        int i = index_map.get(rootval);
        
        root.left = buildTree(preorder, inorder, ps+1, ps+i-is, is, i-1);
        root.right = buildTree(preorder, inorder, ps+i-is+1, pe, i+1, ie);
        return root;
    }
}