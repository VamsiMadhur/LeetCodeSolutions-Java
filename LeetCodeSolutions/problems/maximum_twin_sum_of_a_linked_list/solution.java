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
    public int pairSum(ListNode head) {
        ListNode fast = head.next, slow = head;
        while(fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        
        ListNode prev = null, t = temp;
        while(temp != null) {
            t = temp.next;
            temp.next = prev;
            prev = temp;
            temp = t;
        }
        int sum=0;
        while(head!=null) {
            sum = Math.max(head.val + prev.val, sum);
            prev = prev.next;
            head = head.next;
        }
        return sum;
    }
}