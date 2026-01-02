class Solution {
  public void rotate(int[][] matrix) {

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = matrix[j][i];
      }
    }

    int upper = matrix.length - 1;
    int lower = 0;

    while (upper > lower) {
      for (int i = 0; i < matrix[0].length; i++) {
        int tmp = matrix[i][lower];
        matrix[i][lower] = matrix[i][upper];
        matrix[i][upper] = tmp;
      }
      upper--;
      lower++;
    }

  }
}
