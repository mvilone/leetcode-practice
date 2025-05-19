package arrays;

import java.util.ArrayList;

class CreateTargetArray {

    /**
     * Creates a target array by inserting elements from the nums array at positions specified by the index array.
     *
     * <p>For each element in nums, it is inserted into a list at the corresponding index from the index array.
     * After all insertions, the list is converted back into a primitive integer array and returned.</p>
     *
     * @param nums the array of values to insert
     * @param index the array of positions where values from nums should be inserted
     * @return the final target array after all insertions
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        // 1. Create a dynamic list to build the target array with insert operations
        ArrayList<Integer> numsCopy = new ArrayList<>();

        // 2. Insert each number from nums into the list at the specified index
        for (int i = 0; i < nums.length; i++) {
            numsCopy.add(index[i], nums[i]);
        }

        // 3. Convert the ArrayList into a fixed-size int[] array for the result
        int[] result = new int[numsCopy.size()];
        for (int i = 0; i < numsCopy.size(); i++) {
            result[i] = numsCopy.get(i);
        }

        return result;
    }
}

