/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) {
            return head;
        }
        Node curr = head;
        
        while(curr!=null) {
            Node newNode = new Node(curr.val);
            Node temp = curr.next;
            curr.next = newNode;
            newNode.next = temp;
            curr = temp;
        }
        
        curr = head;
        while(curr!=null) {
            Node randomNode = curr.random;
            if(randomNode!=null) {
                curr.next.random = randomNode.next;
            }
            curr = curr.next.next;
        }
        
        curr = head;
        Node newHead = head.next;
        while(curr!=null) {
            Node newList = curr.next;
            
            curr.next = newList.next;
            if(curr.next!=null) {
                newList.next = curr.next.next;
            } else {
                newList.next = null;
            }
            curr = curr.next;
        }
        
        return newHead;
        
    }
}