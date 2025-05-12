package arrays;

import java.util.HashMap;

class SplitTheArray {

    /**
     * Determines whether it's possible to split the given array into two arrays 
     * such that no number appears more than once in either of the two arrays.
     *
     * The idea is to count the frequency of each number. If any number appears 
     * more than twice, it's impossible to split it between two arrays without a duplicate.
     *
     * @param nums the input array of integers
     * @return true if a valid split is possible, false otherwise
     */
    public boolean isPossibleToSplit(int[] nums) {
        // Map to store the frequency of each unique number
        HashMap<Integer, Integer> frequency = new HashMap<>();

        // Count the occurrences of each number in the array
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // If any number appears more than twice, we can't split it into two arrays without duplication
        for (Integer count : frequency.values()) {
            if (count > 2) {
                return false;
            }
        }

        // If no number exceeds 2 occurrences, a valid split is possible
        return true;
    }
}

