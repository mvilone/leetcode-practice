package math;

import java.util.ArrayList;
import java.util.List;

class FizzBuzz {

    /**
     * Generates a list of strings representing numbers from 1 to n with substitutions:
     * - "Fizz" for numbers divisible by 3,
     * - "Buzz" for numbers divisible by 5,
     * - "FizzBuzz" for numbers divisible by both 3 and 5,
     * - the number itself otherwise.
     *
     * @param n the upper bound of the range (inclusive)
     * @return a list of strings with the FizzBuzz transformation
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(); // List to store FizzBuzz results

        for (int i = 1; i <= n; i++) {
            // Check if divisible by both 3 and 5 first
            if ((i % 3) == 0 && (i % 5) == 0) {
                result.add("FizzBuzz");
            }
            // Check if divisible by 3 only
            else if ((i % 3) == 0) {
                result.add("Fizz");
            }
            // Check if divisible by 5 only
            else if ((i % 5) == 0) {
                result.add("Buzz");
            }
            // If not divisible by 3 or 5, add the number itself
            else {
                result.add(String.valueOf(i));
            }
        }

        return result; // Return the completed FizzBuzz list
    }
}

