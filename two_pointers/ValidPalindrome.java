package two_pointers;

class ValidPalindrome {

    /**
     * Checks if a given string is a valid palindrome.
     * 
     * A string is considered a valid palindrome if, after converting all uppercase 
     * letters to lowercase and removing all non-alphanumeric characters, it reads 
     * the same forward and backward.
     *
     * @param s the input string
     * @return true if the string is a valid palindrome, false otherwise
     */
    public boolean isPalindrome(String s) {
        char[] input = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        // Use two pointers from both ends to compare characters
        while (start < end) {
            char c1 = Character.toLowerCase(input[start]);
            char c2 = Character.toLowerCase(input[end]);

            // If both characters are alphanumeric, compare them
            if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2)) {
                if (c1 != c2) {
                    return false; // mismatch means it's not a palindrome
                }
                start++;
                end--;
            } 
            // Skip non-alphanumeric characters on the left
            else if (!Character.isLetterOrDigit(c1)) {
                start++;
            } 
            // Skip non-alphanumeric characters on the right
            else if (!Character.isLetterOrDigit(c2)) {
                end--;
            } 
            // If both characters are non-alphanumeric, skip both
            else {
                start++;
                end--;
            }
        }

        // If we make it through the loop, it's a valid palindrome
        return true;
    }
}

