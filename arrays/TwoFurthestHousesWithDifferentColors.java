package arrays;
class TwoFurthestHousesWithDifferentColors {

    /**
     * Finds the maximum distance between two houses with different colors.
     * The colors are represented as integers in the input array, where each element
     * corresponds to the color of a house.
     *
     * The function checks the maximum possible distance from:
     * 1. The first house to any other house with a different color.
     * 2. The last house to any other house with a different color.
     *
     * @param colors an array where colors[i] represents the color of the i-th house
     * @return the maximum distance between two houses with different colors
     */
    public int maxDistance(int[] colors) {
        int max1 = 0;
        int firstColor = colors[0];

        // Traverse from the beginning, comparing each house with the first house
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] != firstColor) {
                int distance = i;
                if (distance > max1) {
                    max1 = distance;
                }
            }
        }

        int max2 = 0;
        int lastColor = colors[colors.length - 1];

        // Traverse from the end, comparing each house with the last house
        for (int i = colors.length - 2; i >= 0; i--) {
            if (colors[i] != lastColor) {
                int distance = (colors.length - 1) - i;
                if (distance > max2) {
                    max2 = distance;
                }
            }
        }

        // Return the greater of the two distances found
        return Math.max(max1, max2);
    }
}
