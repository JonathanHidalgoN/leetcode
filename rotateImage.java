class Solution {
  public void rotate(int[][] matrix) {

    int nRows = matrix.length;
    int nCols = matrix[0].length;

    for (int row = 0; row < nRows; row++) {
      for (int col = row; col < nCols; col++) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
      }
    }

    int numberOfSwaps = nCols / 2;
    for (int swap = 0; swap < numberOfSwaps; swap++) {
      int leftCol = swap;
      int rightCol = nCols - swap - 1;
      for (int row = 0; row < nRows; row++) {
        int temp = matrix[row][leftCol];
        matrix[row][leftCol] = matrix[row][rightCol];
        matrix[row][rightCol] = temp;
      }
    }

  }
}
