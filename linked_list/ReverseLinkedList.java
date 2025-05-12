package linked_list;

/**
 * Definition for singly-linked list node.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseLinkedList {

    /**
     * Reverses a singly-linked list.
     *
     * The algorithm uses iterative in-place reversal. It traverses the list once,
     * and for each node, reverses the direction of the pointer to its previous node.
     *
     * @param head the head of the original singly-linked list
     * @return the head of the reversed list
     */
    public ListNode reverseList(ListNode head) {
        // Pointer to traverse the list
        ListNode current = head;

        // Previous node starts as null since the new tail's next should be null
        ListNode prev = null;

        // Traverse and reverse each node's link
        while (current != null) {
            // Temporarily store the next node before reversing
            ListNode next = current.next;

            // Reverse the current node's pointer
            current.next = prev;

            // Move prev and current one step forward
            prev = current;
            current = next;
        }

        // At the end, prev will be the new head of the reversed list
        return prev;
    }
}

