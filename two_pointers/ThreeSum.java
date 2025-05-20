package two_pointers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Finds all unique triplets in the array that sum up to zero.
 *
 * <p>This method uses a sorted array and two-pointer technique to efficiently find all
 * valid combinations. Duplicate triplets are avoided by skipping repeated values
 * during iteration.</p>
 *
 * @param nums the input array of integers
 * @return a list of unique triplets where each triplet's elements sum to zero
 */
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array to simplify two-pointer traversal and duplicate detection
        Arrays.sort(nums);

        List<List<Integer>> final_result = new ArrayList<>();

        // Iterate through each element, treating it as the first number of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first number to avoid repeated triplets
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int left = i + 1;                // Second pointer
            int right = nums.length - 1;     // Third pointer

            // Use two-pointer approach to find valid triplets
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a valid triplet
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    final_result.add(temp);

                    // Skip over duplicates for the second number
                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1;
                    }

                    // Skip over duplicates for the third number
                    while (left < right && nums[right] == nums[right - 1]) {
                        right -= 1;
                    }

                    // Move both pointers inward after recording a valid triplet
                    left += 1;
                    right -= 1;
                } else if (sum < 0) {
                    // Sum is too small, move left pointer to increase it
                    left += 1;
                } else {
                    // Sum is too large, move right pointer to decrease it
                    right -= 1;
                }
            }
        }

        return final_result;
    }
}
