import java.util.HashSet;
import java.util.Set;

class Solution {

  private boolean explore(char[][] board, String word, Set<String> exploredIdxs, int idxWantedChar, int currentRow,
      int currentCol) {

    if (idxWantedChar == word.length()) {
      return true;
    }

    if (exploredIdxs.contains(currentRow + "," + currentCol)) {
      return false;
    }

    if (currentRow > board.length - 1 || currentRow < 0 || currentCol > board[0].length - 1 || currentCol < 0) {
      return false;
    }

    if (board[currentRow][currentCol] == word.charAt(idxWantedChar)) {
      exploredIdxs.add(currentRow + "," + currentCol);
      boolean down = explore(board, word, exploredIdxs, idxWantedChar + 1, currentRow + 1, currentCol);
      if (down)
        return true;
      boolean up = explore(board, word, exploredIdxs, idxWantedChar + 1, currentRow - 1, currentCol);
      if (up)
        return true;
      boolean right = explore(board, word, exploredIdxs, idxWantedChar + 1, currentRow, currentCol + 1);
      if (right)
        return true;
      boolean left = explore(board, word, exploredIdxs, idxWantedChar + 1, currentRow, currentCol - 1);
      if (left)
        return true;
      exploredIdxs.remove(currentRow + "," + currentCol);
    }

    return false;

  }

  public boolean exist(char[][] board, String word) {

    int numberOfRows = board.length;
    int numberOfCols = board[0].length;
    Set<String> exploredIdxs = new HashSet<>();

    for (int currentRow = 0; currentRow < numberOfRows; currentRow++) {
      for (int currentCol = 0; currentCol < numberOfCols; currentCol++) {
        boolean result = explore(board, word, exploredIdxs, 0, currentRow, currentCol);
        if (result) {
          return true;
        }
      }
    }

    return false;

  }
}
