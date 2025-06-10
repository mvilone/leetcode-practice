package math;
class PowXN {

    /**
     * Calculates x raised to the power of n (i.e., x^n).
     * 
     * This method efficiently computes powers using recursive divide-and-conquer,
     * with proper handling for negative exponents and edge cases like Integer.MIN_VALUE.
     * 
     * The exponent is promoted to a long to safely negate Integer.MIN_VALUE,
     * which cannot be represented as a positive int.
     *
     * Time Complexity: O(log n) — each recursive call halves the exponent.
     *
     * @param x the base value
     * @param n the exponent (can be negative)
     * @return the result of x raised to the power n
     */
    public double myPow(double x, int n) {
        // Promote exponent to long to handle Integer.MIN_VALUE without overflow
        long exponent = n;

        // Base case: any number to the power 0 is 1
        if (exponent == 0) {
            return 1.0;
        }

        // If the exponent is negative, invert x and make exponent positive
        if (exponent < 0) {
            exponent *= -1;
            x = 1 / x;
        }

        // Base case: x^1 = x
        if (exponent == 1) {
            return x;
        }

        // Recursive step: compute x^(exponent / 2)
        // Cast back to int to match method signature
        double half = myPow(x, (int)(exponent / 2));

        // If exponent is even: x^n = (x^(n/2))^2
        // If exponent is odd:  x^n = x * (x^(n/2))^2
        if ((exponent % 2) == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}
