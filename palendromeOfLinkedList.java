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
    public boolean isPalindrome(ListNode head) {
        boolean isOdd = false;
        // ListNode mid = head;//end front -> midSize-1;
        ListNode temp = head;
        ListNode len = head;
        int size = 0;
        int midSize = 0;//actual middle -1 if odd and == if even
        
        //get last node
        while(len != null) {
            len = len.next;
            size++;
        }
        
        if(size == 1) {
            return true;
        }
        
        //check for odd
        if(size % 2 != 0) {
            isOdd = true;
        }
        
        //set middle size
        midSize = (size/2);
        
        StringBuilder sbFront = new StringBuilder();
        StringBuilder sbBack = new StringBuilder();
        
        if(isOdd) {
            //get front string
            for(int i = 0; i < midSize; i++) {
                System.out.println(temp.val);
                sbFront.append(temp.val);
                temp = temp.next;
            }
            sbFront.append(temp.val);
        } else {
            //get front string
            for(int i = 0; i < midSize; i++) {
                System.out.println(temp.val);
                sbFront.append(temp.val);
                temp = temp.next;
            }
        }
        
        //get back string
        for(int i = midSize+1; i <= size; i++) {
            System.out.println(temp.val);
            sbBack.append(temp.val);
            temp = temp.next;
        }
        //reverse back
        sbBack.reverse();
        
        if(sbFront.toString().equals(sbBack.toString())) {
            return true;
        }
        else {
            return false;
        }
    }
}