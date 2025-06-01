class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode node = head, prev = null, next;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}