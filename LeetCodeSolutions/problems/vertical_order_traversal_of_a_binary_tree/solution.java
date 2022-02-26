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
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> cache;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        cache = new TreeMap<>();
        
        traversal(root,0, 0);
        
        cache.values().forEach(row -> {
            List<Integer> temp = new ArrayList<>();
            row.values().forEach(k -> {Collections.sort(k); temp.addAll(k);});
            result.add(temp);
        });
        return  result;
    }
    
    public void traversal(TreeNode root, int row, int column) {
        if(root == null) return;
        
        cache.computeIfAbsent(column, k -> new TreeMap<>())
            .computeIfAbsent(row, k-> new ArrayList()).add(root.val);
        traversal(root.left, row+1, column-1);
        traversal(root.right, row+1, column+1);
    }
    
    
}