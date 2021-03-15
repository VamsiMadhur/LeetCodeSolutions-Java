/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            
            List<Node> children = node.children;
            for(int i=children.size()-1; i>=0; i--) {
                stack.push(children.get(i));
            }
        }
        return result;
    }
}