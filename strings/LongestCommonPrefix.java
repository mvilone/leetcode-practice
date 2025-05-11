package strings;

class LongestCommonPrefix {

    /**
     * Helper method to find the length of the shortest string in the array.
     *
     * @param strs the array of strings
     * @return the length of the shortest string
     */
    public int min(String[] strs) {
        int min = strs[0].length();
        for (String s : strs) {
            if (s.length() < min) {
                min = s.length();
            }
        }
        return min;
    }

    /**
     * Finds the longest common prefix string among an array of strings.
     * If there is no common prefix, returns an empty string.
     *
     * @param strs the array of strings to examine
     * @return the longest common prefix shared among all strings
     */
    public String longestCommonPrefix(String[] strs) {
        // 1. Determine the length of the shortest string in the array
        int length = min(strs);

        // 2. Iterate character by character up to the shortest length
        //    - For each position, check if all strings have the same character
        //    - If any mismatch is found, stop and return the current prefix
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c1 = strs[0].charAt(i);
            boolean common = true;

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c1) {
                    common = false;
                    break;
                }
            }

            if (common) {
                result.append(c1);
            } else {
                break;
            }
        }

        return result.toString();
    }
}

