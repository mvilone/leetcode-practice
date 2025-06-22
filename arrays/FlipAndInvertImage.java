package arrays;

class FlipAndInvertImage {

    /**
     * Flips a binary array horizontally and then inverts it.
     * Flipping is done by reversing the array, and inversion is done by switching 0s to 1s and 1s to 0s.
     *
     * @param input A binary array representing a row of an image.
     */
    public void transform(int[] input) {
        int[] result = new int[input.length];

        // Flip the input array by copying elements in reverse order
        for (int i = input.length - 1; i >= 0; i--) {
            int other = (input.length - 1) - i;  // Target index in the result array
            result[other] = input[i];
        }

        // Invert each bit: 1 becomes 0, and 0 becomes 1
        for (int i = 0; i < input.length; i++) {
            input[i] = (result[i] == 1) ? 0 : 1;
        }
    }

    /**
     * Applies a horizontal flip followed by a binary inversion to each row of the 2D binary image.
     *
     * @param image A 2D array representing a binary image.
     * @return The transformed image after flipping and inverting.
     */
    public int[][] flipAndInvertImage(int[][] image) {
        // Transform each row of the image
        for (int[] row : image) {
            transform(row);
        }

        return image;
    }
}

