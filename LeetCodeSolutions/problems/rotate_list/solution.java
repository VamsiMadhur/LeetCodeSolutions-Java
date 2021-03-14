/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0) {
            return head;
        }
        int count = 0;
        ListNode node = head;
        ListNode endNode = head;
        while(node!=null) {
            ++count;
            endNode = node;
            node = node.next;
        }
        k = (k%count);
        node = head;
        if(k!=0) {
            k = count-k;
            ListNode prev = null;
            for(int i=0; i<k; i++) {
                prev = node;
                node = node.next;
            }
            if(prev!=null) {
                prev.next = null;
            }
            endNode.next = head;
        }
        return node;
    }
}