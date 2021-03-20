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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if((head == null) || (head.next == null) || (left == right)) {
            return head;
        }
        
        int count = 1;
        ListNode curr = head;
        ListNode leftNode = null;
        ListNode prevNode = null;
        
        while(curr!=null) {
            if(count == left) {
                leftNode = curr;
                break;
            }
            prevNode = curr;
            curr = curr.next;
            count++;
        }

        ListNode prev = null;
        while(curr!=null && count<=right) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev=curr;
            curr = temp;
            count++;
        }
        
        leftNode.next = curr;
        if(prevNode == null) {
            head = prev;
        } else {
            prevNode.next = prev;
        }
        
        return head;
    }
}