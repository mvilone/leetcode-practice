package two_pointers;

import java.util.*;

/**
 * Finds all unique triplets in the array that sum to zero.
 *
 * <p>This implementation sorts the array and uses a two-pointer approach
 * to efficiently find combinations. It stores the triplets in a HashSet
 * to automatically handle duplicate triplets.</p>
 *
 * @param nums the input array of integers
 * @return a list of unique triplets [nums[i], nums[j], nums[k]] such that i != j != k and their sum is 0
 */
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array to enable two-pointer traversal
        Arrays.sort(nums);

        // Use a HashSet to automatically filter out duplicate triplets
        HashSet<List<Integer>> triplets = new HashSet<>();

        // Iterate through each element to use as the first number in the triplet
        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i];
            int j = i + 1;                 // Start of second pointer
            int k = nums.length - 1;       // Start of third pointer

            // Use two-pointer technique to find valid triplets
            while (j < k) {
                int n2 = nums[j];
                int n3 = nums[k];
                int sum = n1 + n2 + n3;

                if (sum == 0) {
                    // Found a valid triplet that sums to zero
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(n1);
                    triplet.add(n2);
                    triplet.add(n3);
                    triplets.add(triplet);

                    // Move both pointers inward to continue search
                    j += 1;
                    k -= 1;
                } else if (sum < 0) {
                    // Sum is too small, move left pointer right to increase sum
                    j += 1;
                } else {
                    // Sum is too large, move right pointer left to decrease sum
                    k -= 1;
                }
            }
        }

        // Convert HashSet to List for the final result
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> t : triplets) {
            result.add(t);
        }

        return result;
    }
}

