package linked_list;


/**
 * Provides functionality to remove the N-th node from the end of a singly linked list.
 */
public class RemoveNthNodeFromEnd {
    //Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Advances the given node by 'n' steps forward in the linked list.
     *
     * @param node the starting node
     * @param n the number of steps to move forward
     * @return the node after moving 'n' steps, or null if the end is reached before that
     */
    public ListNode nextStep(ListNode node, int n) {
        if (node == null) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            node = node.next;
            if (node == null) {
                return null; // Reached the end before completing n steps
            }
        }
        return node;
    }

    /**
     * Removes the nth node from the end of the list and returns the updated head.
     *
     * @param head the head of the linked list
     * @param n the position from the end of the node to remove
     * @return the head of the modified linked list
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Edge case: empty list or only one node
        if ((head == null) || (head.next == null)) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = nextStep(head, n); // Move fast pointer n steps ahead

        // If fast is null after n steps, we're removing the head node
        if (fast == null) {
            return head.next;
        }

        // Move both pointers forward until fast reaches the last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end by skipping it
        slow.next = slow.next.next;

        return head;
    }
}

