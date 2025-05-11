package strings;

import java.util.HashMap;

class RomanToInteger {

    /**
     * Converts a Roman numeral string to its corresponding integer value.
     * Roman numerals are represented by the characters I, V, X, L, C, D, and M.
     * Subtractive notation (e.g., IV = 4) is handled by subtracting the current value if the next is greater.
     *
     * @param s the Roman numeral string (1 to 15 characters, valid symbols only)
     * @return the integer value of the Roman numeral
     */
    public int romanToInt(String s) {
        // 1. Create a map of Roman numeral symbols and their integer values
        HashMap<Character, Integer> map = new HashMap<>();
        char[] symbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0; i < symbols.length; i++) {
            map.put(symbols[i], values[i]);
        }

        // 2. Traverse the Roman numeral string
        //    - If the current value is less than the next one, subtract it
        //    - Otherwise, add it
        int result = 0;
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length - 1; i++) {
            int current = map.get(sChar[i]);
            int next = map.get(sChar[i + 1]);

            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }

        // 3. Add the last character’s value
        result += map.get(sChar[sChar.length - 1]);

        return result;
    }
}

