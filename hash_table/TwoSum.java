package hash_table;

import java.util.HashMap;

public class TwoSum {

    /**
     * Finds two indices such that the numbers at those indices add up to the target.
     * Assumes exactly one solution exists.
     *
     * @param nums   the input array of integers
     * @param target the target sum
     * @return an array containing the two indices
     */
    public int[] twoSum(int[] nums, int target) {
        // 1. Map to store seen numbers and their indices
        HashMap<Integer, Integer> visited = new HashMap<>();

        // 2. Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            int complement = target - element;

            // 3. Check if complement exists in the map
            Integer i2 = visited.get(complement);
            if (i2 != null) {
                return new int[] { i2, i };
            }

            // 4. Store the current number and its index
            visited.put(element, i);
        }

        // No valid pair found (per problem, this won't happen)
        return null;
    }
}
