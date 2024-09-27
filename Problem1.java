import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    // Back Tracking
    // TC : O(n!)
    // SC : O(n)
    List<List<String>> result;
    boolean[][] grid;

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return new ArrayList<>();
        result = new ArrayList<>();
        grid = new boolean[n][n];
        backTracking(0);
        return result;
    }

    private void backTracking(int raw) {
        //base case
        if (raw == grid.length) {
            List<String> rawList = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < grid.length; j++) {
                    if (grid[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                rawList.add(sb.toString());
//                return;
            }
            result.add(rawList);

        }

        //logic
        for (int i = 0; i < grid.length; i++) {
            if (isSafe(raw, i)) {
                grid[raw][i] = true;
                backTracking(raw + 1);
                grid[raw][i] = false;
            }
        }

    }

    private boolean isSafe(int raw, int col) {
        //check the column
        for (int i = 0; i < raw; i++) {
            if (grid[i][col]) return false;
        }
        //check the above right
        int i = raw;
        int j = col;
        while (i >= 0 && j < grid.length) {
            if (grid[i][j]) return false;
            i--;
            j++;
        }
        //check the above left
        i = raw;
        j = col;
        while (i >= 0 && j >= 0) {
            if (grid[i][j]) return false;
            i--;
            j--;
        }
        return true;
    }
}
