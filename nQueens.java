/*
This is a classic example of backtracking dfs or bfs
Tc --> n!
Sc --> O(n*m)
 */
class Solution {

    boolean[][] board;
    int ROW;
    int COL;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        board = new boolean[n][n];
        ROW = n;
        COL = n;
        res = new ArrayList<>();
        backtrack(0);
        return res;

    }

    public boolean isSafe(int r, int c) {
        //check for same row-up
        int row;
        int col;

        row = r - 1;
        while (row >= 0) {
            if (board[row][c] == true) {
                return false;
            }
            row--;
        }//while

        //check for left up
        row = r - 1;
        col = c - 1;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == true) {
                return false;
            }
            row -= 1;
            col -= 1;
        }//while

        //check for right up
        row = r - 1;
        col = c + 1;
        while (row >= 0 && col < COL) {
            if (board[row][col] == true) {
                return false;
            }
            row -= 1;
            col += 1;

        }//while

        return true;
    }

    public void backtrack(int idx) {
        //base

        if (idx == ROW) {
            List<String> path = new ArrayList<>();
            for (int i = 0; i < ROW; i++) {
                StringBuilder s = new StringBuilder();

                for (int k = 0; k < COL; k++) {
                    if (board[i][k] == true) {
                        s.append('Q');
                    } else {
                        s.append('.');
                    }

                }//for

                String st = new String(s.toString());
                path.add(st);

            }//for

            res.add(new ArrayList<>(path));

        }//if

        //logic
        for (int j = 0; j < COL; j++) {
            if (isSafe(idx, j)) {

                board[idx][j] = true;
                backtrack(idx + 1);
                board[idx][j] = false;

            }//if

        }//for

    }//method
}//class
