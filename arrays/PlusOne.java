package arrays;

import java.util.ArrayList;

class PlusOne {

    /**
     * Increments the integer represented by a digit array by one.
     * The most significant digit is at the head of the array, and each element contains a single digit (0–9).
     *
     * Handles carry-over logic when adding 1, including cases like [9, 9] → [1, 0, 0].
     *
     * @param digits the input array representing a non-negative integer
     * @return a new array representing the incremented integer
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Case 1: If the last digit is less than 9, we can just increment it and return early.
        if (digits[n - 1] < 9) {
            digits[n - 1] += 1;
            return digits;
        }

        // Convert the array to a dynamic list to handle insertions and carry logic
        ArrayList<Integer> result = new ArrayList<>();
        for (int digit : digits) {
            result.add(digit);
        }

        // Start by setting the last digit to 0 (since it was 9 and now rolls over)
        result.set(n - 1, 0);

        // Special case: if the array has only one digit (which was 9), we need to insert 1 at the front
        if (n == 1) {
            result.add(0, 1);
        }

        // Traverse the digits from right to left to handle cascading carry-overs
        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] == 9) {
                result.set(i, 0);
                // If we've reached the most significant digit and still carrying over, insert a 1 at the front
                if (i == 0) {
                    result.add(0, 1);
                }
            } else {
                // No further carry needed; just increment and break
                result.set(i, result.get(i) + 1);
                break;
            }
        }

        // Convert the result list back to an array
        int[] resultToArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultToArray[i] = result.get(i);
        }

        return resultToArray;
    }
}

