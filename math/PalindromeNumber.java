package math;

public class PalindromeNumber {
     public boolean isPalindrome(int x) {
        // 1. Return true if x is 0, since 0 is a palindrome
        if (x == 0) {
            return true;
        }

        // 2. Return false for cases that can't be palindromes:
        //    - negative numbers
        //    - numbers ending in 0 (except 0 itself)
        if (x < 0 || (x % 10 == 0)) {
            return false;
        }

        // 3. Reverse the number step by step and compare with input
        int reversed = 0;

        while (reversed < x) {
            int lastDigit = x % 10;
            reversed = reversed * 10 + lastDigit;

            // Check for equality before reducing x further
            if (x == reversed) {
                break;
            }

            x /= 10;
        }

        // 4. Return whether the reversed value equals the remaining part of x
        return reversed == x;
    }
    
}
