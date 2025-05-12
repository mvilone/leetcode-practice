package array2d;

class ImageSmoother {

    /**
     * Computes the average value of the current cell and all valid neighboring cells
     * in a 3x3 grid centered at (i, j) in the given 2D image matrix.
     *
     * Boundary checks are performed to ensure neighbors are within image bounds.
     *
     * @param img the input 2D image matrix
     * @param i the row index of the current cell
     * @param j the column index of the current cell
     * @return the floor of the average value of the current cell and its neighbors
     */
    public int average(int[][] img, int i, int j) {
        int sum = 0;
        int count = 0;

        // Define the bounds of the 3x3 grid centered at (i, j)
        int x1 = i - 1;
        int x2 = i + 1;
        int y1 = j - 1;
        int y2 = j + 1;

        // Traverse the 3x3 grid and accumulate valid neighbor values
        for (int a = x1; a <= x2; ++a) {
            for (int b = y1; b <= y2; ++b) {
                // Check if the current neighbor is within image bounds
                if (a >= 0 && a < img.length && b >= 0 && b < img[0].length) {
                    sum += img[a][b];
                    count++;
                }
            }
        }

        return sum / count;
    }

    /**
     * Applies a smoothing filter to the input image by replacing each pixel
     * with the average of its own value and its valid neighboring pixels.
     *
     * @param img a 2D integer array representing the grayscale image
     * @return a new 2D integer array representing the smoothed image
     */
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];

        // Traverse each cell in the image and compute the smoothed value
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = average(img, i, j);
            }
        }

        return result;
    }
}

