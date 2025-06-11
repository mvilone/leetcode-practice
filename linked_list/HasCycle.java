package linked_list;

public class HasCycle {
    
    //Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Determines whether a singly linked list contains a cycle using Floyd's Tortoise and Hare algorithm.
     *
     * <p>This method uses two pointers: one moving one step at a time (slow),
     * and one moving two steps at a time (fast). If a cycle exists in the list,
     * these pointers will eventually meet. If the fast pointer reaches the end of
     * the list (null), then no cycle exists.</p>
     *
     * @param head the head of the singly linked list
     * @return true if a cycle exists, false otherwise
     */
    public boolean hasCycle(ListNode head) {
        // Initialize slow and fast pointers
        ListNode one = head; // slow pointer
        ListNode two = head; // fast pointer

        // Traverse the list while fast pointer and its next node are not null
        while (two != null && two.next != null) {
            one = one.next;           // move slow pointer by 1 step
            two = two.next.next;      // move fast pointer by 2 steps

            // If both pointers meet, there is a cycle
            if (one == two) {
                return true;
            }
        }

        // If fast pointer reaches the end, there is no cycle
        return false;
    }
}

