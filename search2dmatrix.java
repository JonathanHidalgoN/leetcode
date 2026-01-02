class Solution {

  private int[] mapRowAndCol(int nCols, int idx) {

    int row = idx / nCols;
    int col = idx % nCols;

    return new int[] { row, col };
  }

  public boolean searchMatrix(int[][] matrix, int target) {

    int nRows = matrix.length;
    int nCols = matrix[0].length;
    int nElements = nRows * nCols;
    int low = 0;
    int high = nElements - 1;

    while (low <= high) {

      int middle = (low + high) / 2;
      int[] coords = mapRowAndCol(nCols, middle);
      int element = matrix[coords[0]][coords[1]];
      if (element == target) {
        return true;
      } else if (element < target) {
        low = middle + 1;
      } else {
        high = middle - 1;
      }

    }

    return false;

  }
}
