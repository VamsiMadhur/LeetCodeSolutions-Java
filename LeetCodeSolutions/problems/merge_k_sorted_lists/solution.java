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
        if(n<1) return null;
        if(n==1) return lists[0];
        
        ListNode[] newlists = new ListNode[(n+1)/2];
        int count = 0;
        
        for(int i=0; i<n-1; i=i+2) {
            ListNode first = lists[i];
            ListNode second = lists[i+1];
            
            ListNode temp = new ListNode(0);
            ListNode t = temp;
            
            while(first!=null && second!=null) {
                if(first.val < second.val) {
                    temp.next = first;
                    temp = temp.next;
                    first = first.next;
                } else {
                    temp.next = second;
                    temp = temp.next;
                    second = second.next;
                }
            }
            if(first == null) {
                while(second != null) {
                    temp.next = second;
                    temp = temp.next;
                    second = second.next;
                }
            } else {
                while(first!=null) {
                    temp.next = first;
                    temp = temp.next;
                    first = first.next;
                }
            }
            newlists[count++] = t.next;
        }
        if(n%2 == 1) {
            newlists[count] = lists[n-1];
        }
        return mergeKLists(newlists);
    }
}