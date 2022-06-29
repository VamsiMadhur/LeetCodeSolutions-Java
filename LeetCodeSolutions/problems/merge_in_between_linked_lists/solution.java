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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        for(int i=0; i<a-1; i++) {
            head = head.next;
        }
        ListNode prev = head;
        for(int i=a-1; i<=b; i++) {
            head = head.next;
        }
        prev.next = list2;
        while(list2.next != null) list2=list2.next;
        list2.next = head;
        return list1;
    }
}