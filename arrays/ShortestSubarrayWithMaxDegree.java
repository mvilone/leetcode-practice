package arrays;

import java.util.HashMap;

class ShortestSubarrayWithMaxDegree {

    /**
     * Finds the length of the smallest contiguous subarray of nums
     * that has the same degree as the original array.
     * The degree is the highest frequency of any single element in the array.
     *
     * @param nums the input array of non-negative integers
     * @return the length of the smallest subarray with the same degree
     */
    public int findShortestSubArray(int[] nums) {
        // Map to track each number's [first index, last index, count]
        HashMap<Integer, int[]> tracker = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (tracker.get(n) == null) {
                // First time seeing this number: set first and last index to i, count = 1
                int[] store = new int[3];
                store[0] = i;  // first index
                store[1] = i;  // last index
                store[2] = 1;  // count
                tracker.put(n, store);
            } else {
                // Update last index and increment count
                tracker.get(n)[1] = i;
                tracker.get(n)[2] += 1;
            }
        }

        // Find the degree (maximum frequency)
        int max = Integer.MIN_VALUE;
        for (int[] array : tracker.values()) {
            if (array[2] > max) {
                max = array[2];
            }
        }

        // Find the shortest subarray length among those with the same degree
        int min = Integer.MAX_VALUE;
        for (int[] array : tracker.values()) {
            int length = (array[1] - array[0]) + 1;
            if ((array[2] == max) && (length < min)) {
                min = length;
            }
        }

        return min;
    }
}

