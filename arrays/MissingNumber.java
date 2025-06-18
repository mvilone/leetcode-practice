package arrays;

class MissingNumber {

    /**
     * Finds the missing number from an array containing n distinct numbers
     * taken from the range [0, n].
     *
     * The function calculates the expected sum of numbers from 0 to n using the
     * Gauss formula and subtracts the actual sum of elements in the array.
     * The difference is the missing number.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums the input array containing n distinct numbers from 0 to n (inclusive), missing one number
     * @return the missing number
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected = (n * (n + 1)) / 2; // Expected sum of numbers from 0 to n
        int actual = 0;

        // Calculate the actual sum of numbers in the array
        for (int i = 0; i < n; i++) {
            actual += nums[i];
        }

        // The missing number is the difference between expected and actual sums
        return expected - actual;
    }
}

