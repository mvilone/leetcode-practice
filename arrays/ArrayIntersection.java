package arrays;

import java.util.HashSet;

class ArrayIntersection {

    /**
     * Returns the intersection of two integer arrays as an array of unique elements.
     *
     * The method uses HashSets to efficiently identify common elements between the two arrays.
     * - It first adds all elements from nums1 into a HashSet.
     * - Then, it checks each element of nums2 against the set and adds it to the result set if found.
     * - Finally, it converts the result set into an array.
     *
     * Time Complexity: O(n + m), where n = nums1.length and m = nums2.length
     * Space Complexity: O(n + k), where k is the number of intersecting elements
     *
     * @param nums1 the first input array
     * @param nums2 the second input array
     * @return an array of unique elements present in both input arrays
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> visited = new HashSet<>(); // Stores elements from nums1
        for (int n : nums1) {
            visited.add(n);
        }

        HashSet<Integer> intersect = new HashSet<>(); // Stores intersection results
        for (int n : nums2) {
            if (visited.contains(n)) { // If element is in nums1, add to result set
                intersect.add(n);
            }
        }

        // Convert the result set to an array
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer n : intersect) {
            result[i] = n;
            i += 1;
        }

        return result;
    }
}

