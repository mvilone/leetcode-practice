package two_pointers;

import java.util.HashMap;

/**
 * Finds the length of the longest substring without repeating characters.
 *
 * <p>This method uses a sliding window approach with a HashMap to keep track
 * of the most recent index of each character seen. When a duplicate character is
 * encountered within the current window, the left pointer is moved past its previous index.</p>
 *
 * @param s the input string
 * @return the length of the longest substring with all unique characters
 */
class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; // Left pointer of the sliding window
        int max = 0;  // Tracks the maximum length found
        HashMap<Character, Integer> visited = new HashMap<>(); // Maps characters to their latest index

        for (int right = 0; right < s.length(); right++) {
            // Check if the character was seen and lies within the current window
            Integer visit = visited.get(s.charAt(right));
            if ((visit != null) && (visit >= left)) {
                // Move the left pointer to the right of the previous occurrence
                left = visit + 1;
            }

            // Update the current character's index
            visited.put(s.charAt(right), right);

            // Update the max length of the current valid window
            max = Math.max(max, ((right + 1) - left));
        }

        return max; // Return the maximum length found
    }
}

