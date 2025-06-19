package arrays;

class CountBinarySubstrings {

    /**
     * Counts the number of binary substrings in the input string `s` that contain the same number of 
     * consecutive 0's and 1's and where all 0's and all 1's are grouped consecutively.
     * 
     * A valid substring must contain equal consecutive 0's followed by 1's or 1's followed by 0's 
     * (e.g., "0011", "01", "1100", etc.).
     *
     * @param s the binary string to evaluate
     * @return the total number of valid binary substrings
     */
    public int countBinarySubstrings(String s) {
        int count = 0;  // Tracks the current group's length
        int[] counts = new int[s.length()];  // Stores lengths of consecutive 0's or 1's
        int size = 0;  // Number of groups found so far
        int current = s.charAt(0);  // Start tracking with the first character

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If we see a character different from the current group, record the group
            if (c != current) {
                counts[size] = count;  // Save the length of the completed group
                count = 0;             // Reset counter for the new group
                size += 1;             // Move to next group
                current = c;           // Update current group character
            }

            count += 1;  // Increment count for the current group
        }

        counts[size] = count;  // Store the final group's length
        size += 1;             // Update size to reflect the total number of groups

        int result = 0;
        // Count valid binary substrings by comparing each pair of adjacent groups
        for (int i = 0; i < (size - 1); i++) {
            result += Math.min(counts[i], counts[i + 1]);
        }

        return result;
    }
}

