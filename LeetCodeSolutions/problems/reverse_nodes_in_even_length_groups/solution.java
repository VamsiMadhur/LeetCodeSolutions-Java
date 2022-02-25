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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode newHead = new ListNode(0, head);
        ListNode prevTail = newHead;
        
        int length = 0;
        ListNode x = head;
        while(x != null) {
            x = x.next;
            length++;
        }
        
        int remaining = length;
        int count = 1;
        while(remaining > 0) {
            int curr = count<remaining ? count : remaining;
            
            if(curr %2 == 0) {
                ListNode prev = null;
                ListNode currHead = head;
                while(curr != 0) {
                    ListNode temp = head.next;
                    head.next = prev;
                    prev = head;
                    head = temp;
                    curr--;
                }
                prevTail.next = prev;
                prevTail = currHead;
            } else {
                prevTail.next = head;
                while(curr != 0) {
                    prevTail = prevTail.next;
                    head = head.next;
                    curr--;
                }
            }
            remaining -= count;
            count++;
        }
        return newHead.next;
    }
}