/*          Leetcode 143
 Q- You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 Example 1:
    Input: head = [1,2,3,4]
    Output: [1,4,2,3]

Example 2:        
    Input: head = [1,2,3,4,5]
    Output: [1,5,2,4,3]

Constraints:

    The number of nodes in the list is in the range [1, 5 * 104].
    1 <= Node.val <= 1000
 */

//  Solution-
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

 // Time complexity - o(N);
 // Space complexity - o(1);s
class Solution {
    public void reorderList(ListNode head) {
        if(head.next==null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;  // slow is the middle element 
        } 
        ListNode revHead = reverse(slow);
        
        while(revHead.next!=null){
            ListNode temp = head.next;
            ListNode temp2 = revHead.next;
            head.next = revHead;
            revHead.next = temp;
            head = temp;
            revHead = temp2;
        }
    }
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;
        
        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

//