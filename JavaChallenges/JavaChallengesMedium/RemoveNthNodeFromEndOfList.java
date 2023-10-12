// Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

// Example 1:


// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []


//remember to go backwards
//take difference find index, go to 1 before index and skip over it (edge case: first node) last node doesn't matter because.next is null
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


//can also do it this way:
//set the boundaries then incrmeent both like a window
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;

    // Move the first pointer n nodes ahead
    for (int i = 1; i <= n + 1; i++) {
        first = first.next;
    }

    // Move first to the end, maintaining the gap with the second pointer
    while (first != null) {
        first = first.next;
        second = second.next;
    }

    // Remove the nth node from the end
    second.next = second.next.next;

    return dummy.next;
}
