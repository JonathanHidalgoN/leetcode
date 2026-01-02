class Solution {
  public void setZeroes(int[][] matrix) {

    int numberOfRows = matrix.length;
    int numberOfCols = matrix[0].length;

    boolean setFirstRowToZero = false;
    boolean setFirstColToZero = false;

    for (int row = 0; row < numberOfRows; row++) {
      for (int col = 0; col < numberOfCols; col++) {

        if (matrix[row][col] == 0) {

          if (row == 0) {
            setFirstRowToZero = true;
          } else {
            matrix[row][0] = 0;
          }

          if (col == 0) {
            setFirstColToZero = true;
          } else {
            matrix[0][col] = 0;
          }
        }
      }
    }

    for (int row = 0; row < numberOfRows; row++) {

      if (row == 0) {
        continue;
      }

      for (int col = 0; col < numberOfCols; col++) {

        if (col == 0) {
          continue;
        }

        if (matrix[row][0] == 0 || matrix[0][col] == 0) {
          matrix[row][col] = 0;
        }

      }
    }

    if (setFirstColToZero) {
      for (int row = 0; row < numberOfRows; row++) {
        matrix[row][0] = 0;
      }
    }

    if (setFirstRowToZero) {
      for (int col = 0; col < numberOfCols; col++) {
        matrix[0][col] = 0;
      }
    }

  }
}
