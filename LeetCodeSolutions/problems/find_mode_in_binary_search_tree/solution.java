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
    int prev=-100001, prevCount=-1, count=0;
    List<Integer> result = new ArrayList<>();
    
    public int[] findMode(TreeNode root) {   
        inorder(root);
        int[] arr = new int[result.size()];
        int i=0;
        for(int num:result) arr[i++] = num;
        return arr;
    }
    
    public void inorder(TreeNode root) {
        if(root == null) return;
        
        inorder(root.left);
        if(prev == root.val) {
            count++;
        } else {
            count=0;
        }
        
        if(count == prevCount) {
            result.add(root.val);
        } else if(count > prevCount) {
            result.clear();
            result.add(root.val);
            prevCount = count;
        } 
        prev = root.val;
        inorder(root.right);
    }
}