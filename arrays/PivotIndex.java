package arrays;

class PivotIndex {

    /**
     * Finds the pivot index of the given integer array.
     * The pivot index is where the sum of the elements strictly to the left
     * is equal to the sum of the elements strictly to the right.
     * If no such index exists, returns -1.
     *
     * @param nums The input array of integers.
     * @return The leftmost pivot index, or -1 if it doesn't exist.
     */
    public int pivotIndex(int[] nums) {
        int totalsum = 0;

        // First, calculate the total sum of the array
        for (int n : nums) {
            totalsum += n;
        }

        int leftsum = 0;

        // Iterate through the array and check pivot condition at each index
        for (int i = 0; i < nums.length; i++) {
            // rightsum = total sum - left sum - current element
            int rightsum = totalsum - leftsum - nums[i];

            // Check if left and right sums are equal
            if (leftsum == rightsum) {
                return i; // Found the pivot index
            }

            // Update left sum by adding the current element
            leftsum += nums[i];
        }

        // No pivot index found
        return -1;
    }
}
