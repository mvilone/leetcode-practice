package strings;
//1876. Substrings of Size Three with Distinct Characters
class CountGoodSubString {

    /**
     * Counts the number of substrings of length 3 in the input string that consist of all distinct characters.
     *
     * <p>A substring is considered "good" if it has exactly three characters and all of them are different.
     * This method iterates through the string and checks each substring of length 3 to determine if it meets this condition.</p>
     *
     * @param s the input string to evaluate
     * @return the number of good substrings of length 3 with all distinct characters
     */
    public int countGoodSubstrings(String s) {
        int count = 0;
        // Loop through the string, stopping at length - 2 to extract 3-character substrings
        for (int i = 0; i < s.length() - 2; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            char c3 = s.charAt(i + 2);
            // Check if all three characters are distinct
            if ((c1 != c2) && (c2 != c3) && (c1 != c3)) {
                count += 1; // Valid good substring found
            }
        }
        return count; // Return the total number of good substrings
    }
}

