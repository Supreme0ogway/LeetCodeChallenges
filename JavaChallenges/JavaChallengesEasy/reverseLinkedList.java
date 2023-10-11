// Given the head of a singly linked list, reverse the list, and return the reversed list.

 

// Example 1:


// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
// Example 2:


// Input: head = [1,2]
// Output: [2,1]
// Example 3:

// Input: head = []
// Output: []


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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next; // Save the next node
            current.next = prev; // Reverse the pointer of current node
            prev = current; // Move prev to current node
            current = next; // Move current to next node
        }

        return prev; // Return the new head of the reversed list
    }
}


//redo
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
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prv = null;
        ListNode n = null;
        
        while(cur != null) {
            //switch
            n = cur.next;
            cur.next = prv;
            //adjust
            prv = cur;
            cur = n;
        }
        return prv;
    }
}


//another solution
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
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode pres = head;
        ListNode nxt = head;

        while(pres != null) {
            //increment next
            if(nxt != null) {
                nxt = pres.next;
            }
            //reverse pres next to last
            pres.next = last;
            //set last to pres
            last = pres;
            //set pres to next
            pres = nxt;
        }

        return last;
    }
}