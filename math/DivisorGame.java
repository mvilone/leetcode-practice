package math;

class DivisorGame {

    /**
     * Solves the Divisor Game problem.
     * 
     * The idea is simple: if the starting number n is even, Alice can always win by playing optimally.
     * If n is odd, then no matter what x she picks, the result n - x will be even, and Bob will win.
     * So basically, the first player (Alice) wins if n is even, and loses if n is odd.
     *
     * @param n the starting number on the chalkboard
     * @return true if Alice wins, false otherwise
     */
    public boolean divisorGame(int n) {
        // If n is even, Alice can always force Bob into an odd number next turn
        // Eventually Bob hits 1 on his turn and loses
        // If n is odd, Alice gives Bob an even number and he wins instead
        return n % 2 == 0;
    }
}

