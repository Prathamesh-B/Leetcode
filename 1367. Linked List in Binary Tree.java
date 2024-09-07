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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null)
            return false;

        // if head val, found in tree
        // search path
        if (head.val == root.val) {
            if (searchPath(head, root))
                return true;
        }

        // path didn't find
        // now search in left subtree,
        // if didn't found search in right subtree
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean searchPath(ListNode listNode, TreeNode treeNode) {
        // base cases
        // if tree node reched to end,
        // check list node reached to end or node
        if (treeNode == null)
            return listNode == null;

        // list node reached to end, it meand found
        if (listNode == null)
            return true;

        // if treeNode val is not match with list val,
        // return, no need to search further
        if (treeNode.val != listNode.val)
            return false;

        return searchPath(listNode.next, treeNode.left)
                || searchPath(listNode.next, treeNode.right);
    }

}