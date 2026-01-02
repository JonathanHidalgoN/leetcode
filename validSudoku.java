import java.util.HashSet;
import java.util.Set;

class Solution {

  private boolean checkCol(char[][] board, int n, Set<Character> set) {
    for (int i = 0; i < board[0].length; i++) {
      char element = board[i][n];
      if (element == '.') {
        continue;
      } else if (set.contains(element)) {
        return false;
      } else {
        set.add(element);
      }
    }
    return true;
  }

  private boolean checkRow(char[][] board, int n, Set<Character> set) {
    for (int i = 0; i < board[0].length; i++) {
      char element = board[n][i];
      if (element == '.') {
        continue;
      } else if (set.contains(element)) {
        return false;
      } else {
        set.add(element);
      }
    }
    return true;
  }

  private boolean checkSquare(char[][] board, int n, Set<Character> set) {
    int col = 0;
    int row = 0;

    if (n < 3) {
      row = 2;
    } else if (n < 6) {
      row = 5;
    } else {
      row = 8;
    }

    if (n == 0 || n == 3 || n == 6) {
      col = 2;
    } else if (n == 1 || n == 4 || n == 7) {
      col = 5;
    } else {
      col = 8;
    }

    for (int i = row - 2; i <= row; i++) {
      for (int j = col - 2; j <= col; j++) {
        char element = board[i][j];
        if (element == '.') {
          continue;
        } else if (set.contains(element)) {
          return false;
        } else {
          set.add(element);
        }
      }
    }

    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      boolean validCol = checkCol(board, i, new HashSet<Character>());
      boolean validRow = checkRow(board, i, new HashSet<Character>());
      boolean validSquare = checkSquare(board, i, new HashSet<Character>());
      if (!validCol || !validRow || !validSquare) {
        return false;
      }
    }
    return true;
  }
}
