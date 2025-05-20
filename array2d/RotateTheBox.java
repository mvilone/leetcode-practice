package array2d;

/**
 * Rotates a box represented as a 2D character grid 90 degrees clockwise after simulating gravity.
 *
 * <p>Each row is processed to simulate the effect of gravity on stones ('#') such that they fall
 * to the right until blocked by an obstacle ('*') or another stone. Then, the entire box is rotated
 * 90 degrees clockwise to produce the final output.</p>
 *
 * @param boxGrid a 2D character array representing the box
 * @return the rotated box grid after stones have settled due to gravity
 */
class RotateTheBox {
    public char[][] rotateTheBox(char[][] boxGrid) {
        // Simulate gravity row by row
        for (int i = 0; i < boxGrid.length; i++) {
            int write = boxGrid[i].length - 1; // Position to "drop" the next stone

            // Traverse the row from right to left
            for (int j = boxGrid[i].length - 1; j >= 0; j--) {
                char c = boxGrid[i][j];

                if (c == '*') {
                    // Obstacle found: reset the write pointer just before the obstacle
                    write = j - 1;
                } 
                else if (c == '#') {
                    // Found a stone that can fall
                    if (j != write) {
                        boxGrid[i][j] = '.';           // Empty the original stone position
                        boxGrid[i][write] = c;         // Move the stone to the "write" position
                    }
                    write -= 1; // Move write pointer left for the next potential stone
                }
                // If c == '.', do nothing and continue scanning
            }
        }

        // Rotate the entire grid 90 degrees clockwise
        char[][] finalGrid = new char[boxGrid[0].length][boxGrid.length];
        for (int i = 0; i < boxGrid.length; i++) {
            for (int j = 0; j < boxGrid[i].length; j++) {
                finalGrid[j][boxGrid.length - 1 - i] = boxGrid[i][j];
            }
        }

        return finalGrid;
    }
}

