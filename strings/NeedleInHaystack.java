package strings;

class NeedleInHaystack {

    /**
     * Finds the index of the first occurrence of the substring 'needle' in the string 'haystack'.
     * If 'needle' is not part of 'haystack', returns -1.
     *
     * This method uses a brute-force approach by sliding a window of 'needle.length()' across
     * 'haystack' and comparing substrings directly.
     *
     * @param haystack The full string in which to search.
     * @param needle The substring to find within 'haystack'.
     * @return The index of the first occurrence of 'needle' in 'haystack', or -1 if not found.
     */
    public int strStr(String haystack, String needle) {
        // If the needle is longer than haystack, it can't be found
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int length = needle.length();  // Store the length of the needle once

        // Slide a window of size 'length' across the haystack
        for (int i = 0; i <= (haystack.length() - length); i++) {
            // Extract the current substring of the same length as needle
            String substring = haystack.substring(i, i + length);

            // Compare the extracted substring with the needle
            if (substring.equals(needle)) {
                return i;  // Found a match, return the starting index
            }
        }

        // No match found after scanning the haystack
        return -1;
    }
}

