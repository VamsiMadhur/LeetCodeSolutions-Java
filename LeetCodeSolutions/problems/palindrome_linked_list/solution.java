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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) {
            return true;
        }
        int size = 0;
        ListNode curr = head;
        while(curr!=null) {
            size++;
            curr = curr.next;
        }
        int halfWay = size/2;
        int counter = 0;
        int[] lookup = new int[halfWay];
        curr = head;
        while(counter<halfWay) {
            lookup[counter++] = curr.val;
            curr = curr.next;
        }
        if(size%2!=0)
            curr = curr.next;
        while(curr!=null) {
            if(curr.val != lookup[--counter]) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
}