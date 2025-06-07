package hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TopKFrequentElements {
    /**
     * Returns the k most frequent elements in the given array.
     * Uses bucket sort to group elements by frequency and extracts the most frequent ones.
     *
     * @param nums the input array of integers
     * @param k    the number of top frequent elements to return
     * @return an array of the k most frequent elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();

        // Count the frequency of each number in the array
        for (int i = 0; i < nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }

        // Create a bucket array where index = frequency
        List<Integer>[] bucket = new List[nums.length + 1];

        // Populate the buckets with numbers grouped by their frequency
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int pos = 0;

        // Traverse buckets from highest frequency to lowest
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (pos == k) {
                break; // Stop once we've collected k elements
            }

            if (bucket[i] != null) {
                // Collect elements from this frequency bucket
                for (Integer key : bucket[i]) {
                    if (pos == k) {
                        break;
                    }
                    result[pos] = key;
                    pos += 1;
                }
            }
        }

        return result;
    }
}

