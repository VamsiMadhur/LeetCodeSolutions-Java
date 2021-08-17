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

class Pair {
    public TreeNode node;
    public int maxSoFar;
    
    public Pair(TreeNode node, int maxSoFar) {
        this.node = node;
        this.maxSoFar = maxSoFar;
    }
}

class Solution {
    
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right==null) return 1;
    
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));
        int size = 1;

        while(size > 0) {
            Pair curr = queue.poll(); 
            size--;
            if(curr.node.val >= curr.maxSoFar){
                curr.maxSoFar = curr.node.val;
                answer++;  
            }

            if(curr.node.left!=null) {
                queue.offer(new Pair(curr.node.left, curr.maxSoFar));
                size++;
            }
            if(curr.node.right!=null) {
                queue.offer(new Pair(curr.node.right, curr.maxSoFar));
                size++;
            }
        }
        return answer;
    }
}