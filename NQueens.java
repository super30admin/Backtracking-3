class Solution {
    /*
        TC - O(n * n!) - isValid takes n time and n! time to go through all placements
        SC - O(n^2) for visited board, and O(n) for recursive stack
        Place queens row by row 
            - For each row, try placing a queen in every column. Before placing, 
            check if that position is safe.
        In isValid function
            - A position (row, col) is valid if there is no queen: in the same column, 
            on the left diagonal, and on the right diagonal.
        If a position is valid, place the queen and recursively solve for the next row.
        After returning, remove the queen to try another column.
        When row == n, all queens have been placed successfully. Convert the visited board into 
        the required string representation and add it to the result.
    */
    List<List<String>> result;
    boolean[][] visited;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.visited = new boolean[n][n];
        helper(n, 0);
        return result;
    }

    private void helper(int n, int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n)) {
                visited[row][col] = true;
                helper(n, row + 1);
                visited[row][col] = false;
            }
        }
    }

    private boolean isValid(int row, int col, int n) {
        int i = row;
        int j = col;
        while (i >= 0) {
            if (visited[i][j]) {
                return false;
            }
            i--;
        }

        i = row;
        j = col;

        while (j >= 0 && i >= 0) {
            if (visited[i][j]) {
                return false;
            }
            i--;
            j--;
        }

        i = row;
        j = col;

        while (j < n && i >= 0) {
            if (visited[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}