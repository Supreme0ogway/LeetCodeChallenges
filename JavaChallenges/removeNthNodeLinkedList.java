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