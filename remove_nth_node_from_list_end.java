/*      Leetcode 19
Q-  Given the head of a linked list, remove the nth node from the end of the list and return its head.
Example 1:
    Input: head = [1,2,3,4,5], n = 2
    Output: [1,2,3,5]

Example 2:
    Input: head = [1], n = 1
    Output: []

Example 3:
    Input: head = [1,2], n = 1
    Output: [1]

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 
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
Solution - 
/*
below approach fails for the test case-
Input
    [1,2]
    2
Output
    [1]
Expected
    [2]
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return (null);
        }
        int length = 0;
        ListNode curr = head;
        while(head!=null){
            length++;
            head = head.next;
        }
        head = curr;
        for(int i=0;i<length-n-1;i++){
            head=head.next;
        }
        head.next = head.next.next;
        return curr;
    }
}

//double pass approach(above approach missing the egde case solution)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return (null);
        }
        int length = 0;
        ListNode curr = head;
        while(head!=null){
            length++;
            head = head.next;
        }
        head = curr;
         if(length<2)
            return null;
        
        if(length-n==0)
            return head.next;
        
        for(int i=0;i<length-n-1;i++){
            head=head.next;
        }
        head.next = head.next.next;
        return curr;
    }
}

// Single pass
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        ListNode fast = head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        ListNode slow = head;
        
        if(fast==null){
            return head.next;    
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}