********************************* test if Linked list is in a loop *****************

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> map = new HashSet<ListNode>();//stores unique values, no duplicates
        ListNode iterator = head;
        
        while(iterator != null) {
            if(iterator.next == null) {
                return false;
            } else {
                if(map.contains(iterator)) {
                    return true;
                } else {
                    map.add(iterator);
                }
                iterator = iterator.next;
            }
        }
        return false;
    }
}
