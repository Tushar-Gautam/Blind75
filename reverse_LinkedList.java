 /*             Leetcode - 206
 Q-Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]

Example 2:
    Input: head = [1,2]
    Output: [2,1]

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?


Solution-
*/

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

 //Iterative solution

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;
        
        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev =  curr;
            curr = temp;
        }
        
        return prev;
    }
}

//Recursive solution
class Solution {
      public ListNode reverseList(ListNode head) {
        return helper(head, null);
    }
    
    public ListNode helper(ListNode head, ListNode prev){
        if(head == null) return prev;
        ListNode next = head.next;
        head.next = prev;
        return helper(next, head); // next is our new Head and head is our prev
    }
}
