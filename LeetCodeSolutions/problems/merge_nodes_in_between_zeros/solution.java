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
    public ListNode mergeNodes(ListNode head) {
        ListNode node = head.next;
        ListNode prev = head;
        int sum = 0;
        while(node != null) {
            if(node.val == 0 && sum!=0) {
                node.val = sum;
                prev.next = node;
                prev = node;
                sum=0;
            } else  {
                sum += node.val;
            }
            node = node.next;
        }
        return head.next;
    }
}