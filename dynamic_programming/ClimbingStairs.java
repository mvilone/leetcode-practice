package dynamic_programming;

class ClimbingStairs {
    private int[] results;

    /**
     * Calculates the number of distinct ways to climb to the top of a staircase with n steps,
     * where each move can either be 1 or 2 steps at a time.
     * 
     * Uses top-down dynamic programming (memoization) to cache and reuse results
     * for improved performance.
     *
     * @param n the total number of steps to reach the top
     * @return the number of unique ways to climb to the top
     */
    public int climbStairs(int n) {
        // Initialize or expand the memoization array if needed
        if ((results == null) || (results.length < (n + 1))) {
            results = new int[n + 1];
        }

        // Return cached result if it already exists
        if (results[n] != 0) {
            return results[n];
        }

        int result;

        // Handle base cases:
        // n == 0: 1 way (do nothing)
        // n == 1: 1 way (1 step)
        // n == 2: 2 ways (1+1, 2)
        // n == 3: 3 ways (1+1+1, 1+2, 2+1)
        if ((n == 0) || (n == 1) || (n == 2) || (n == 3)) {
            result = (n == 0) ? 1 : n;
        } 
        else {
            // Recursively compute ways to reach step n using memoization
            result = climbStairs(n - 2) + climbStairs(n - 1);
        }

        // Store the computed result to avoid recomputation
        results[n] = result;

        return result;
    }
}

