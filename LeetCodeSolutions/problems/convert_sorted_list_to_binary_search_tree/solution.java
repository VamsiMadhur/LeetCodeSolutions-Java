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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private ListNode head;
    
    private int findSize(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp!=null) {
            temp = temp.next;
            size++;
        }
        return size;
    }
    
    private TreeNode convertToBST(int start, int end) {
        if(start>end) {
            return null;
        }
        int mid = start + (end-start)/2;
        TreeNode left = convertToBST(start, mid-1);
        
        TreeNode curr = new TreeNode(head.val);
        head = head.next;
        
        curr.left = left;
        curr.right = convertToBST(mid+1, end);
        return curr;
    }
    public TreeNode sortedListToBST(ListNode head) {
        int size = findSize(head);
        this.head = head;
        return convertToBST(0, size-1);
    }
}