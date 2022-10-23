//tc: O(n!)
// sc: O(n^2) + O(n)
class Solution {
    boolean[][] grid;
    int n;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {

        result = new ArrayList<>();

        if (n ==0) return result;
        this.n = n;
        grid = new boolean[n][n];
        backtrack(0);
        return result;
    }

    private void backtrack(int row) {
        //base
        if (row == n) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j=0; j < n; j++) {
                    if (grid[i][j] == true) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            result.add(ans);
            return;
        }


        // logic
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                //action
                grid[row][col] = true;
                //recurse
                backtrack(row+1);
                //backtrack
                grid[row][col] = false;
            }
        }
    }

    private boolean isSafe (int row, int col) {
        for (int i = row-1; i >=0; i--) {
            if (grid[i][col] == true) {
                return false;
            }
        }

        int i = row-1;
        int j = col-1;
        while (i >=0 && j>=0) {
            if (grid[i][j] == true) {
                return false;
            }
            i--;
            j--;
        }

        i = row-1;
        j = col+1;
        while (i >=0 && j<n) {
            if (grid[i][j] == true) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}
