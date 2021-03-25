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

    
    public List<TreeNode> generateTrees(int n) {
        if(n==0) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1,n);
    }
    
    public List<TreeNode> generateTrees(int low, int high) {
        List<TreeNode> result = new ArrayList<>();
        
        if(low>high) {
            result.add(null);
            return result;
        }
        
        for(int i=low; i<=high; i++) {
            List<TreeNode> leftTrees = generateTrees(low, i-1);
            List<TreeNode> rightTrees = generateTrees(i+1, high);
            
            for (TreeNode l : leftTrees) {
                for(TreeNode r : rightTrees) {
                    result.add(new TreeNode(i,l,r));
                }
            }
        }
        return result;
    }
}