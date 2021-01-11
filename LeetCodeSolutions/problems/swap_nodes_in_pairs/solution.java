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
    public ListNode swapPairs(ListNode head) {
        ListNode list = head;
        ListNode prev = null;
        boolean start=true;
        while(head!=null && head.next!=null) {
            ListNode temp = head.next;
            head.next=temp.next;
            temp.next=head;
            if(start) {
                list=temp;
                start=false;
            } else {
                prev.next=temp;
            }
            prev = head;
            head=head.next;
        }
        
        return list;
    }
}