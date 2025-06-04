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
class MergedTwoSortedLists {
    //definition of singly linked class
    private class ListNode {
        int val;
        ListNode next;
         //ListNode() {}
         //ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Tail pointer used to keep track of the last node in the result list
    private ListNode tail = null;

    /**
     * Appends a new node with the given value to the end of the result list.
     *
     * @param val    The integer value to append as a new node.
     * @param result The current head of the result linked list.
     * @return The updated head of the result linked list.
     */
    public ListNode append(int val, ListNode result){
         if(result == null){
            // If result list is empty, create the first node and set it as tail
            result = new ListNode(val, null);
            tail = result;
         }
         else{
            // Otherwise, create a new node and attach it to the tail
            ListNode node = new ListNode(val, null);
            tail.next = node;
            tail = tail.next; // Move the tail to the new last node
         }
         return result;
    }

    /**
     * Merges two sorted linked lists into a single sorted linked list.
     *
     * @param list1 The head of the first sorted linked list.
     * @param list2 The head of the second sorted linked list.
     * @return The head of the new merged sorted linked list.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode store = list1;
        ListNode store2 = list2;
        ListNode result = null;

        // Continue until both lists are fully traversed
        while(!((store == null) && (store2 == null))){
            if ((store != null) && ((store2 == null) || (store.val <= store2.val))){
                // If store is not null and either store2 is null OR store's value is smaller or equal:
                // take value from store, move store pointer right, and append it to result
                result = append(store.val, result);
                store = store.next;
            }
            else{
                // Otherwise:
                // take value from store2, move store2 pointer right, and append it to result
                result = append(store2.val, result);
                store2 = store2.next;
            }    
        }

        return result;
    }

    /**
     * Prints all values in a linked list, separated by commas.
     *
     * @param list The head of the linked list to print.
     */
    public void print(ListNode list){
        ListNode store = list;

        // Traverse and print each node's value
        while(store != null){
            System.out.print(store.val + ", ");
            store = store.next;
        }
        System.out.println(); // New line after the list
    }
}
