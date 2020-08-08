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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int headValue = l1.val + l2.val;
		ListNode head = new ListNode(headValue % 10);
		int nextVal = headValue / 10;
		l1 = l1.next;
		l2 = l2.next;
		ListNode previous = head;
		while (nextVal != 0 || l1 != null || l2 != null) {
			int val = 0;
		
			if (nextVal != 0) {
				val = nextVal % 10;
				nextVal = nextVal / 10;
			}

			int x = 0;
			if (l1 != null) {
				x = l1.val;
				l1 = l1.next;
			}
			int y = 0;
			if (l2 != null) {
				y = l2.val;
				l2 = l2.next;
			}
			val += x + y;

			if (val / 10 > 0) {
				nextVal = val / 10;
				val = val % 10;
			}

			ListNode current = new ListNode(val);
			previous.next = current;
			previous = previous.next;
		}
		return head;
    }
}