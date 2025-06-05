package linked_list;

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
class AddTwoNumbers {

    // Used to track how many nodes have been added to the result list
    private int size = 0;

    // Tail pointer for efficient O(1) appending
    private ListNode tail = null;

    //Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Appends a value to the end of a linked list.
     *
     * @param list The head of the list to append to.
     * @param val  The value to append as a new node (or in-place if first).
     */
    public void append(ListNode list, int val){
        if(size == 0){
            // If it's the first node, set the value in-place
            list.val = val;
            tail = list;
        }
        else{
            // Otherwise, create a new node and attach it to the tail
            ListNode node = new ListNode(val);
            tail.next = node;
            tail = tail.next; // Move the tail to the new node
        }
        size += 1;
    }

    /**
     * Adds two numbers represented by linked lists in reverse order.
     * Each node contains a single digit, and digits are stored least-significant first.
     *
     * @param l1 The head of the first linked list.
     * @param l2 The head of the second linked list.
     * @return A new linked list representing the sum of the two numbers.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;

        // Create a dummy head for the result list
        ListNode result = new ListNode();
        ListNode tail = null;

        // Track carry-over between digit sums
        boolean carry = false;

        // Loop until both lists are fully traversed
        while((current1 != null) || (current2 != null)){
            // Use 0 if one of the lists is shorter
            int i1 = (current1 != null) ? current1.val : 0;
            int i2 = (current2 != null) ? current2.val : 0;

            // Add current digits plus carry if applicable
            int sum = i1 + i2;
            if(carry == true){
                sum += 1;
            }

            // Append the ones-place digit (sum % 10) to the result list
            // This extracts only the current digit, while carry handles the tens place
            append(result, sum % 10);

            // Set carry for next iteration
            if(sum >= 10){
                carry = true;
            }
            else{
                carry = false;
            }

            // Move to next node in each list, if available
            current1 = (current1 != null) ? current1.next : null;
            current2 = (current2 != null) ? current2.next : null;
        }

        // If there's still a carry left after the last digit
        if(carry == true){
            append(result, 1);
        }

        return result;
    }
}

