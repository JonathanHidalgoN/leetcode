import java.util.HashSet;
import java.util.Set;

class Solution {

  private void expand(char[][] grid, Set<String> set, int i, int j) {

    if (set.contains(i + "," + j)) {
      return;
    }

    set.add(i + "," + j);

    if (i + 1 <= grid.length - 1 && grid[i + 1][j] == '1') {
      expand(grid, set, i + 1, j);
    }

    if (j + 1 <= grid[0].length - 1 && grid[i][j + 1] == '1') {
      expand(grid, set, i, j + 1);
    }

    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
      expand(grid, set, i - 1, j);
    }

    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
      expand(grid, set, i, j - 1);
    }

  }

  public int numIslands(char[][] grid) {

    Set<String> set = new HashSet<>();
    int islandCount = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {

        String key = i + "," + j;
        if (set.contains(key)) {
          continue;
        }

        char element = grid[i][j];

        if (element == '1') {
          islandCount++;
          expand(grid, set, i, j);
        } else {
          set.add(key);
        }

      }
    }

    return islandCount;

  }
}
