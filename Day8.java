/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while(first != null){
            if(second.next == null){
                return first;
            }
            if(second.next.next == null){
                return first.next;
            }
            second = second.next.next;
            first = first.next;
        }
        return null;
    }
}