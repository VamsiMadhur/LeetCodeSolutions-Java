/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ta = headA, tb=headB;
        boolean flagA = false, flagB = false;
        while(ta != tb) {
            ta = ta.next;
            tb = tb.next;
            if(!flagA && ta == null) {
                ta = headB;
                flagA = true;
            }
            if(!flagB && tb == null) {
                tb = headA;
                flagB = true;
            }
            if((flagA && ta == null) || (flagB && tb == null)) return null;
        }
        return ta;
    }
}