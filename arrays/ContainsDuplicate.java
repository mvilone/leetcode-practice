package arrays;

import java.util.HashSet;

class Solution {

    /**
     * Checks whether the input array contains any duplicate integers.
     * 
     * This method uses a HashSet to track seen elements while iterating through the array.
     * If an element is already in the set, it means a duplicate exists and the method returns true.
     * 
     * Time Complexity: O(n) average case, due to constant-time HashSet operations.
     * Space Complexity: O(n) for storing elements in the HashSet.
     * 
     * @param nums the array of integers to check for duplicates
     * @return true if any value appears at least twice, false otherwise
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> visited = new HashSet<>(); // Stores unique elements seen so far
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(nums[i])) { // Duplicate found
                return true;
            }
            visited.add(nums[i]); // Mark element as seen
        }
        return false; // No duplicates found
    }
}

