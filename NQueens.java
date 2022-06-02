//Time: O(N - isSafeBoard at every level * N!  - for the recursive call stack and all the possibilites)
// Space: O(N^2)


class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        backTrack(board, 0, n);
        return result;
    }

    private void backTrack(boolean[][] board, int row, int n) {

        if(row==n) {
            List<String> set = new ArrayList<>();
            for(int i=0;i<n;i++) {
                StringBuilder str = new StringBuilder();
                for(int j=0;j<n;j++) {
                    if(board[i][j] == true) {
                        str.append('Q');
                    } else {
                        str.append('.');
                    }
                }
                set.add(str.toString());
            }
            result.add(set);
        }
        // possibilities for q1 is 4, q2 2, q3 1 q4 1 on 4*4 board
        for(int col=0;col<n;col++) {
            // only the curr col is safe for the curr queen
            // we mark it to true in board array
            if(isSafeBoard(board, row, col, n)) {
                board[row][col] = true;
                //then proceed with next queen on next row
                backTrack(board, row+1, n);
                // if queen can not placed at next row in the next recursion call
                // we come back here and backtrack the action
                board[row][col] = false;
            }
        }
    }

    private boolean isSafeBoard(boolean[][] board, int row, int col, int n) {
        int localRow = row-1;
        int localLeftDiagonalCol = col-1;
        int localSameCol = col;
        int localRightDiagonalCol = col+1;
        while(localRow>=0) {
            //up left
            if(localLeftDiagonalCol >= 0) {
                if(board[localRow][localLeftDiagonalCol]) return false;
                localLeftDiagonalCol--;
            }
            //up right
            if(localRightDiagonalCol <n) {
                if(board[localRow][localRightDiagonalCol]) return false;
                localRightDiagonalCol++;
            }
            //up top
            if(board[localRow][col]) return false;
            localRow--;
        }
        return true;
    }
}