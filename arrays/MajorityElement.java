package arrays;

class MajorityElement {

    /**
     * Finds the majority element in an array using the Boyer-Moore Voting Algorithm.
     * The majority element is defined as the element that appears more than n/2 times.
     * This implementation assumes that the majority element always exists, as guaranteed by the problem.
     *
     * @param nums an array of integers where a majority element is guaranteed to exist
     * @return the majority element
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0]; // Initialize the candidate with the first element

        for (int i = 0; i < nums.length; i++) {
            // If count drops to 0, choose current element as the new candidate
            if (count == 0) {
                candidate = nums[i];
            }

            // If current number equals candidate, increment count; else, decrement
            if (nums[i] == candidate) {
                count += 1;
            } else {
                count -= 1;
            }
        }

        // At the end, candidate is the majority element
        return candidate;
    }
}

