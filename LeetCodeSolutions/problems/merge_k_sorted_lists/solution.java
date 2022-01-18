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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n <= 0) return null;
        if(n==1) return lists[0];
        
        ListNode[] newLists = new ListNode[(n+1)/2];
        int count=0;
        
        for(int i=0; i<n-1; i+=2) {
            ListNode first = lists[i];
            ListNode second = lists[i+1];
            
            ListNode temp = new ListNode(0);
            ListNode tHead = temp;
            
            while(first!=null && second!=null) {
                if(first.val < second.val) {
                    temp.next = first;
                    first = first.next;
                } else {
                    temp.next = second;
                    second = second.next;
                }
                temp = temp.next;
            }
            if(first == null) {
                temp.next = second;
            } else {
                temp.next = first;
            }
            newLists[count++] = tHead.next;
        }
        if(n%2 == 1) {
            newLists[count] = lists[n-1];
        }
        return mergeKLists(newLists);
    }
}