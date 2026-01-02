import java.util.ArrayList;
import java.util.List;

class Solution {

  private void normalL(int[][] matrix, List<Integer> ans, int currentRow, int currentColumn,
      int colsToVisit, int rowsToVisit) {

    int visitedCols = 0;
    int visitedRows = 0;

    while (visitedCols != colsToVisit) {
      ans.add(matrix[currentRow][currentColumn]);
      currentColumn++;
      visitedCols++;
    }

    currentRow++;

    while (visitedRows != rowsToVisit) {
      ans.add(matrix[currentRow][currentColumn]);
      currentRow++;
      visitedRows++;
    }

  }

  private void inverseL(int[][] matrix, List<Integer> ans, int currentRow, int currentColumn,
      int colsToVisit, int rowsToVisit) {

    int visitedCols = 0;
    int visitedRows = 0;

    while (visitedCols != colsToVisit) {
      ans.add(matrix[currentRow][currentColumn]);
      currentColumn++;
      visitedCols++;
    }

    currentRow++;

    while (visitedRows != rowsToVisit) {
      ans.add(matrix[currentRow][currentColumn]);
      currentRow++;
      visitedRows++;
    }

  }

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
  }
}
