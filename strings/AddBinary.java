package strings;

class AddBinary {

    /**
     * Adds two binary strings and returns their sum as a binary string.
     * 
     * The method simulates binary addition from the least significant bit (rightmost)
     * to the most significant bit (leftmost), handling carries as needed. It uses a 
     * StringBuilder to build the result in reverse order and reverses it at the end 
     * for the final output.
     * 
     * @param a The first binary string.
     * @param b The second binary string.
     * @return A binary string representing the sum of 'a' and 'b'.
     */
    public String addBinary(String a, String b) {
        int i1 = a.length() - 1;  // Pointer for string 'a' starting from the end
        int i2 = b.length() - 1;  // Pointer for string 'b' starting from the end
        StringBuilder result = new StringBuilder();  // To accumulate result bits
        int carry = 0;  // Holds carry from previous bit addition

        // Loop until all bits in both strings are processed
        while ((i1 >= 0) || (i2 >= 0)) {
            // Get current bits from a and b, or 0 if pointer is out of bounds
            int n1 = (i1 >= 0) ? a.charAt(i1) - '0' : 0;
            int n2 = (i2 >= 0) ? b.charAt(i2) - '0' : 0;

            // Compute sum of bits and carry
            int sum = n1 + n2 + carry;

            // Append current bit (sum % 2) to result
            result.append(sum % 2);

            // Update carry (0 or 1)
            carry = sum / 2;

            // Move pointers leftward
            i1 -= 1;
            i2 -= 1;
        }

        // If carry remains after final addition, append it
        if (carry == 1) {
            result.append(1);
        }

        // Reverse result to get correct binary order and return as string
        return result.reverse().toString();
    }
}

