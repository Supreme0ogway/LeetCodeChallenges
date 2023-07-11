********************* how to remove node from linked list *********************
class Solution {//[4,1,1,9]
    public void deleteNode(ListNode node) {
        ListNode nexter = node.next;
        node.val = nexter.val;
        node.next = nexter.next;
    }
}