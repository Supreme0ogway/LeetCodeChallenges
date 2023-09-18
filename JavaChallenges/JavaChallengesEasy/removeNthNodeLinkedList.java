// Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

// Example 1:


// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []


//remember to go backwards
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode nn = head;
        
        //gets the size
        while(nn.next != null) {
            size++;
            nn = nn.next;
        }
        
        int delIndex = size - n;
        nn = head;
        int i = 0;
        while(i < delIndex-1) {
            nn = nn.next;
            i++;
        }
        
        if (delIndex == 0) {
            head = head.next;
            nn = head;
        } else {
            nn.next = nn.next.next;
            nn = head;
        }
        return nn;
    }
}