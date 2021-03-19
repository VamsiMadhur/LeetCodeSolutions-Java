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
    ListNode tail = new ListNode();
    ListNode nextSubList = new ListNode();
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        int n = getCount(head);
        ListNode start = head;
        ListNode dummyHead = new ListNode();
        for(int size = 1; size<n; size = size*2) {
            tail = dummyHead;
            while(start!=null) {
                if(start.next==null) {
                    tail.next = start;
                    break;
                }
                ListNode mid = split(start, size);
                merge(start, mid);
                start = nextSubList;
            }
            start = dummyHead.next;
        }
        return dummyHead.next;
    }
     
    private void merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode newTail = dummy;
        while(left != null && right!=null) {
            if(left.val < right.val) {
                newTail.next = left;
                left = left.next;
                newTail = newTail.next;
            } else {
                newTail.next = right;
                right = right.next;
                newTail = newTail.next;
            }
        }
        if(left == null) {
            newTail.next = right;
        } else {
            newTail.next = left;
        }
        
        while(newTail.next != null) {
            newTail = newTail.next;
        }
        
        tail.next = dummy.next;
        tail = newTail;
    }
    
    
    private ListNode split(ListNode start, int size) {
        ListNode midPrev = start;
        ListNode end = start.next;
        
        for(int index=1; index<size && (midPrev.next!=null || end.next!=null); index++) {
            if(end.next!=null) {
                if(end.next.next==null) {
                    end = end.next;   
                } else {
                    end = end.next.next;
                }
            }
            if(midPrev.next != null)
                midPrev = midPrev.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        nextSubList = end.next;
        end.next = null;

        return mid;
    }
    
    private int getCount(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while(curr!=null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
    
    
}