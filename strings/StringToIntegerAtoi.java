package strings;

class StringToIntegerAtoi {

    /**
     * Converts a string to a 32-bit signed integer.
     * Follows rules similar to the C/C++ atoi function:
     * - Ignores leading whitespace
     * - Reads optional '+' or '-' sign
     * - Parses digits until non-digit or end of string
     * - Clamps the result to Integer.MIN_VALUE or Integer.MAX_VALUE if overflow occurs
     *
     * @param s the input string to convert
     * @return the parsed integer, or 0 if no valid number can be formed
     */
    public int myAtoi(String s) {
        s = s.trim(); // Remove leading and trailing whitespace
        if(s.length() == 0){
            return 0; // Return 0 for empty string after trimming
        }
        int sign = (s.charAt(0) == '-') ? 1 : 0; // 1 if negative, 0 if positive
        int i = ((s.charAt(0) == '-') || (s.charAt(0) == '+')) ? 1 : 0; // Start index (skip sign if present)
        long result = 0;
        while((i < s.length()) && (Character.isDigit(s.charAt(i)))){ // Parse numeric digits
            char c = s.charAt(i);
            int digit = c - '0';
            result = (result * 10) + digit; // Accumulate the digit

            // Clamp to 32-bit signed integer range if overflow occurs
            if((sign == 1) && (-result < Integer.MIN_VALUE)){
                return Integer.MIN_VALUE;
            }
            if((sign == 0) && (result > Integer.MAX_VALUE)){
                return Integer.MAX_VALUE;
            }
            i += 1;
        }
        if(sign == 1){
            result *= -1; // Apply negative sign if needed
        }
        return (int)result;
    }
}

