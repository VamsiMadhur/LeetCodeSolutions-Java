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
    
    private ListNode ptr = null;
    
    private boolean isOdd = false;
    
    public void reorderList(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ptr = slow;
        if(fast!=null) {
            isOdd = true;
        }
        reorderListRec(head);
    }
    
    public void reorderListRec(ListNode head) {
        if((head==ptr && isOdd) || (!isOdd && head.next == ptr)) {
            return;
        } 
        ListNode node = head;
        reorderListRec(node.next);
        ListNode temp = ptr.next;
        ptr.next = temp.next;
        temp.next = node.next;
        node.next = temp;
    }
}