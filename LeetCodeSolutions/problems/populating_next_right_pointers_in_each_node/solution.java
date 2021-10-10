/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        
        while(size != 0) {
            int nextSize = 0;
            Node prev = null;
            for(int i=0; i<size; i++) {
                Node temp = queue.poll();
                if(prev != null)
                    prev.next = temp;
                if(temp.left != null) {
                    queue.offer(temp.left);
                    nextSize++;
                }
                if(temp.right != null) {
                    queue.offer(temp.right);
                    nextSize++;
                }
                prev = temp;
            }
            size = nextSize;
        }
        return root;
    }
}