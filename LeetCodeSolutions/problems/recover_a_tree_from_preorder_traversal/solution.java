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
    public TreeNode recoverFromPreorder(String traversal) {
        char[] tree = traversal.toCharArray();
        int n = tree.length;
        
        TreeNode[] cache = new TreeNode[1000];
        
        int i=0;
        int val = tree[i] - '0';
        while(i+1 < n && tree[i+1] != '-') {
            val = (val*10) + (tree[i+1] - '0');
            i++;
        }
        i++;
        
        TreeNode root = new TreeNode(val);
        cache[0] =  root;
        
        int count = 0;
        
        while(i<n) {
            if(tree[i] == '-') {
                count++;
            } else {
                val = tree[i] - '0';
                while(i+1 < n && tree[i+1] != '-') {
                    val = (val*10) + (tree[i+1] - '0');
                    i++;
                }
               
                TreeNode temp = new TreeNode(val);
                TreeNode prev = cache[count-1];
                if(prev.left == null) {
                    prev.left = temp;
                } else {
                    prev.right = temp;
                }
                cache[count] =  temp;
                
                count = 0;
            }
            i++;
        }
        return root;
    }
}