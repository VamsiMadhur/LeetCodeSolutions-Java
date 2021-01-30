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
        if(headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        boolean a = false;
        boolean b = false;
        while(!a || !b || (p1 !=null && p2!=null)) {
            if(p1 == p2) {
                return p1;
            }
            if(p1 == null) {
                a = true;
                p1 = headB;
            } else {
                p1 = p1.next;    
            }
            if(p2 == null) {
                b = true;
                p2 = headA;
            } else {
                p2 = p2.next;    
            }
        }
        return null;
    }
}