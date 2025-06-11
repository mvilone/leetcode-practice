package math;

class ReverseInteger {

    /**
     * Reverses the digits of a 32-bit signed integer.
     * 
     * <p>If reversing the integer causes it to go outside the 32-bit signed integer range 
     * [-2^31, 2^31 - 1], the function returns 0 to avoid overflow.</p>
     * 
     * <p>Example:</p>
     * <ul>
     *   <li>Input: 123 → Output: 321</li>
     *   <li>Input: -456 → Output: -654</li>
     *   <li>Input: 1534236469 → Output: 0 (overflow)</li>
     * </ul>
     * 
     * @param x the integer to reverse
     * @return the reversed integer, or 0 if the result overflows
     */
    public int reverse(int x) {
        // Convert input to long to safely handle edge cases like Integer.MIN_VALUE
        long input = Math.abs((long) x);
        long reversed = 0;

        // Build the reversed number digit by digit
        while (input > 0) {
            long lastDigit = input % 10;           // Get the last digit
            reversed = reversed * 10 + lastDigit;  // Append the digit to the reversed number
            input /= 10;                            // Remove the last digit from input
        }

        // Apply the original sign
        reversed = (x < 0) ? -reversed : reversed;

        // Check for 32-bit integer overflow
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }

        // Cast back to int and return the result
        return (int) reversed;
    }
}

