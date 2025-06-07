package arrays;

class RemoveElement {

    /**
     * Shifts all elements of the array one position to the left starting from index n.
     * The last element is overwritten with -1 to indicate it was shifted out.
     *
     * @param n    the starting index from where the shift begins
     * @param nums the array to perform the shift operation on
     */
    public void shift(int n, int[] nums) {
        // Shift elements one position left starting from index n
        for (int i = n; i < (nums.length - 1); i++) {
            nums[i] = nums[i + 1];
        }
        // Mark the last element as removed
        nums[nums.length - 1] = -1;
    }

    /**
     * Removes all occurrences of the specified value from the array in-place
     * by shifting elements and returns the count of remaining valid elements.
     * Removed values are replaced with -1 at the end of the array.
     *
     * @param nums the input array
     * @param val  the value to remove
     * @return the number of valid (non -1) elements remaining in the array
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;

        // Iterate through the array
        while (i < nums.length) {
            if (nums[i] == val) {
                // If element matches the value, shift left to remove it
                shift(i, nums);
            } else {
                // Otherwise, move to the next element
                i += 1;
            }
        }

        // Count how many valid (non -1) elements are left
        int count = 0;
        for (int item : nums) {
            if (item != -1) {
                count += 1;
            }
        }

        return count;
    }
}

