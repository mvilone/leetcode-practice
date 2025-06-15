package arrays;

import java.util.ArrayList;
import java.util.Arrays;

class MergedIntervals {

    /**
     * Merges all overlapping intervals from a given list of intervals.
     * 
     * @param intervals A 2D array where each sub-array represents an interval [start, end].
     * @return A 2D array of non-overlapping intervals that cover all the input intervals.
     */
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals based on their start times
        Arrays.sort(intervals, (self, other) -> Integer.compare(self[0], other[0]));

        // Edge case: if there's only one interval, return it as-is
        if (intervals.length == 1) {
            return intervals;
        }

        // Initialize result list to store merged intervals
        ArrayList<int[]> intervals_result = (ArrayList<int[]>) new ArrayList();

        // Add the first interval to begin comparison
        intervals_result.add(intervals[0]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // Get the last interval in the result list
            int[] last = intervals_result.get(intervals_result.size() - 1);

            // Extract start and end points of last and current intervals
            int x1 = last[0];
            int y1 = last[1];
            int x2 = intervals[i][0];
            int y2 = intervals[i][1];

            // Check if the two intervals overlap
            boolean overlap = (x1 <= y2) && (x2 <= y1);

            if (overlap) {
                // If they overlap, update the end of the last interval
                last[1] = Math.max(y1, y2);
            } else {
                // If not overlapping, add the current interval as a new entry
                intervals_result.add(intervals[i]);
            }
        }

        // Convert the result list back to a 2D array
        int[][] result = new int[intervals_result.size()][2];
        int i = 0;
        for (int[] a : intervals_result) {
            result[i] = a;
            i += 1;
        }

        return result;
    }

}

