package strings;

class RotateString {

    /**
     * Checks if one string is a rotation of another.
     *
     * <p>A string s can be transformed into another string goal by performing a number of
     * left rotations (moving the first character to the end) on s. This method returns true
     * if and only if goal is a rotation of s.</p>
     *
     * @param s the original string
     * @param goal the target string to check against
     * @return true if goal is a rotation of s, false otherwise
     */
    public boolean rotateString(String s, String goal) {
        // 1. If lengths are not equal, s can never be transformed into goal
        if (s.length() != goal.length()) {
            return false;
        }

        // 2. Concatenate s with itself. Any rotation of s will be a substring of (s + s)
        String total = s + s;

        // 3. Check if goal is a substring of the concatenated string
        return total.contains(goal);
    }
}

