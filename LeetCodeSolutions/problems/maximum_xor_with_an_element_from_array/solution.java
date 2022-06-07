class TrieNode {
    TrieNode left, right;
    int min = Integer.MAX_VALUE;
}

class Solution {
    
    public void insert(TrieNode root, int val) {
        for(int i=31; i>=0; i--) {
            int idx = (1<<i)&val;
            if(idx ==0) {
                if(root.left == null) root.left = new TrieNode();
                root = root.left;
            } else {
                if(root.right == null) root.right = new TrieNode();
                root = root.right;
            }
            root.min = Math.min(root.min, val);
        }
    }
    
    public int findMaxXor(TrieNode root, int x, int max) {
        int result = 0;
        for(int i=31; i>=0; i--) {
            int idx = (1<<i)&x;
            if(idx == 0) {
                if(root.right!=null && root.right.min <= max) {
                    root = root.right;
                    result |= (1<<i);
                } else if(root.left !=null && root.left.min <= max) {
                    root = root.left;
                } else {
                    break;
                }
            } else {
                 if(root.left!=null && root.left.min <= max) {
                    root = root.left;
                    result |= (1<<i);
                } else if(root.right !=null && root.right.min <= max) {
                    root = root.right;
                } else {
                     break;
                 }
            } 
        }
        return result;
    }
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        TrieNode root = new TrieNode();
        int minNum = Integer.MAX_VALUE;
        for(int num : nums) {
            minNum = Math.min(minNum, num);
            insert(root, num);
        }
        
        int[] result = new int[queries.length];
        int i=0;
        for(int[] query : queries) {
            if(query[1]<minNum) 
                result[i++] = -1;
            else
                result[i++] = findMaxXor(root, query[0], query[1]);
        }
        return result;
    }
}