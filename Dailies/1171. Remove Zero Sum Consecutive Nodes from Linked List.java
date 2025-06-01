class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
        int prefix = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> seen = new HashMap<>();
        seen.put(0, dummy);
        for (ListNode i = dummy; i != null; i = i.next) {
            prefix += i.val;
            seen.put(prefix, i);
        }
        prefix = 0;
        for (ListNode i = dummy; i != null; i = i.next) {
            prefix += i.val;
            i.next = seen.get(prefix).next;
        }
        return dummy.next;
    }
}