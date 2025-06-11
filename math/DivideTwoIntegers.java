package math;

class DivideTwoIntegers {

    /**
     * Returns the absolute value of a number using only int-safe logic.
     * Handles Integer.MIN_VALUE explicitly since its absolute value (2147483648)
     * cannot be represented in a 32-bit signed integer.
     *
     * @param n the integer input
     * @return the absolute value of n (or Integer.MAX_VALUE if input is Integer.MIN_VALUE)
     */
    public int abs(int n) {
        // Special case: abs(Integer.MIN_VALUE) would overflow,
        // so we return Integer.MAX_VALUE (2147483647) as the closest possible safe value.
        if (n == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        // For any other negative number, flip the sign
        if (n < 0) {
            return -n;
        }

        // If n is already positive, return as is
        return n;
    }

    /**
     * Returns the result of dividing two integers without using multiplication,
     * division, or modulus operators. Truncates toward zero and handles overflow cases.
     *
     * @param dividend the number to be divided
     * @param divisor the number by which to divide
     * @return the integer quotient after division
     *
     * Constraints handled:
     * - 32-bit integer overflow is avoided (e.g. Integer.MIN_VALUE / -1)
     * - No use of *, /, or %
     * - Uses only int (not long) and respects 32-bit signed int limits
     */
    public int divide(int dividend, int divisor) {
        int numerator = abs(dividend);       // Safe absolute value for dividend
        int denominator = abs(divisor);      // Safe absolute value for divisor

        // Determine if the result should be negative
        boolean bothP = (dividend > 0) && (divisor >= 0);
        boolean bothN = (dividend < 0) && (divisor < 0);

        int result = 0;

        // Special case: Integer.MIN_VALUE / -1 = 2147483648, which overflows int
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // If divisor is Integer.MIN_VALUE, only Integer.MIN_VALUE / Integer.MIN_VALUE = 1
        // All other cases return 0 since abs(divisor) > abs(dividend)
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            }
            return 0;
        }

        // Fast path for division by 1
        if (denominator == 1) {
            if (!(bothP || bothN)) {
                // abs(Integer.MIN_VALUE) returns Integer.MAX_VALUE, so we must adjust manually
                if (dividend == Integer.MIN_VALUE) {
                    return -numerator - 1;
                }
                return -numerator;
            }
            return numerator;
        }

        // Main loop: use bit shifting to subtract largest possible multiples of denominator
        while (numerator >= denominator) {
            int temp = denominator;
            int multiple = 1;

            // Double temp and multiple until temp exceeds numerator or shifting would overflow
            while ((temp << 1) <= numerator && temp <= Integer.MAX_VALUE >> 1) {
                temp = temp << 1;
                multiple = multiple << 1;
            }

            // Subtract the chunk and accumulate the multiple
            numerator -= temp;
            result += multiple;
        }

        // Special compensation: abs(Integer.MIN_VALUE) returned one less than the real value
        // So we simulate the correct abs value by checking if one more subtraction fits
        if (dividend == Integer.MIN_VALUE && (numerator + 1) >= denominator) {
            result += 1;
        }

        // Apply sign to result
        if (!(bothP || bothN)) {
            return -result;
        }
        return result;
    }
}
