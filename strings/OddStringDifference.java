package strings;

import java.util.HashMap;

/**
 * Identifies the word in a list that has a unique adjacent character difference pattern.
 *
 * <p>Each word is converted into a pattern based on the difference between each pair of 
 * adjacent characters. All words except one share the same pattern. This class identifies 
 * and returns the word that differs.</p>
 */
class OddStringDifference {

    /**
     * Returns the word with a unique adjacent character difference pattern.
     *
     * @param words an array of lowercase alphabetic strings of the same length
     * @return the word whose difference pattern is unique among all words
     */
    public String oddString(String[] words) {
        // 1. Create an array to hold difference patterns for each word
        StringBuilder[] difference = new StringBuilder[words.length];
        
        for (int i = 0; i < words.length; i++) {
            difference[i] = new StringBuilder();
            
            // Compute the difference between adjacent characters
            for (int j = 0; j < words[i].length() - 1; j++) {
                difference[i].append(words[i].charAt(j + 1) - words[i].charAt(j));
                
                // Append comma only between differences (not after the last one)
                if (j < words[i].length() - 2) {
                    difference[i].append(", ");
                }
            }
        }

        // 2. Track frequency of each pattern and the index where it occurred
        HashMap<String, Integer> frequency = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < difference.length; i++) {
            String key = difference[i].toString();
            frequency.put(key, frequency.getOrDefault(key, 0) + 1);
            indexMap.put(key, i);
        }

        // 3. Find and return the word with the unique pattern
        for (String f : frequency.keySet()) {
            if (frequency.get(f) == 1) {
                return words[indexMap.get(f)];
            }
        }

        return "";
    }
}
