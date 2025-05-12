package hash_table;

import java.util.HashMap;

class ValidAnagram {

    /**
     * Checks if two strings are anagrams of each other.
     *
     * Two strings are anagrams if they contain the same characters in the same frequency,
     * but possibly in a different order.
     *
     * @param s the first input string
     * @param t the second input string
     * @return true if s and t are anagrams, false otherwise
     */
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Map to track the frequency of each character
        HashMap<Character, Integer> frequency = new HashMap<>();

        // Increase frequency for s, decrease for t (simultaneously)
        for (int i = 0; i < s.length(); i++) {
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
            frequency.put(t.charAt(i), frequency.getOrDefault(t.charAt(i), 0) - 1);
        }

        // If all frequencies are zero, the strings are anagrams
        for (Integer count : frequency.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}

