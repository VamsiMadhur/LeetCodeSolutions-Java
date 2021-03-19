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
      public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null) {
            ListNode nextNode = curr.next;
            if(prev.val > curr.val) {
                ListNode prevT = null;
                ListNode currT = head;   
                while(curr.val >= currT.val) {
                    prevT = currT;
                    currT = currT.next;
                }
                
                if(prevT!=null) {
                    prevT.next = curr;
                } else {
                    head = curr;
                }
                curr.next = currT;
                prev.next = nextNode;
            } else {
                prev = curr;
            }
            curr = nextNode;
        }
        return head;
    }
}