package math;

import java.util.HashSet;

class HappyNumber {

    /**
     * Calculates the sum of the squares of each digit in the given number.
     * 
     * For example, if n = 19, this method returns 1^2 + 9^2 = 82.
     *
     * @param n the input integer
     * @return the sum of the squares of its digits
     */
    public int sumOfSquares(int n) {
        int sum = 0;

        // Repeatedly extract the last digit, square it, and add to the sum
        while (n >= 10) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        // Add the square of the last remaining digit (when n < 10)
        sum += n * n;

        return sum;
    }

    /**
     * Determines whether a number is a "happy number".
     *
     * A happy number is defined as a number that eventually reaches 1
     * when replaced by the sum of the squares of its digits, repeatedly.
     * If it falls into a cycle that doesn't include 1, it's not a happy number.
     *
     * @param n the input number to check
     * @return true if n is a happy number, false otherwise
     */
    public boolean isHappy(int n) {
        // Set to track numbers we've seen before to detect cycles
        HashSet<Integer> visited = new HashSet<>();

        // Keep processing until we reach 1 or detect a loop
        while (n > 1) {
            // Replace n with the sum of the squares of its digits
            n = sumOfSquares(n);

            // If we've seen this number before, we're in a cycle
            if (visited.contains(n)) {
                return false;
            }

            // Add the current number to the visited set
            visited.add(n);
        }

        // If we exit the loop because n == 1, it's a happy number
        return true;
    }
}

