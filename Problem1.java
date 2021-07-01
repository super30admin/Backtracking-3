// Time - O(N!)
// Space - O(N^2)


class Solution {

    List<List<String>> result;
    int [][] board;
    public List<List<String>> solveNQueens(int n) {

        board = new int[n][n];
        result = new ArrayList<>();

        // call backtrack function on row and column
        backtrack(0,n);

        return result;

    }

    private void backtrack(int r, int n) {

        // base

        // if hits the last row
        if (r == n) {

            List<String> li = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                // we are outputting each row
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(board[i][j] == 1) {
                        sb.append('Q');
                    }
                    else {
                        sb.append('.');
                    }

                }
                li.add(sb.toString());

            }
            // add final list to main list
            result.add(li);

        }




        //logic

        // column iteration
        for(int j = 0; j < n; j++) {

            if(isSafe(r,j,n)) {

                // action
                board[r][j] = 1;

                //recurse
                // move to the next row
                backtrack(r+1, n);

                // backtrack
                // make the current element at row and column 0 while backtracking
                board[r][j] = 0;

            }

        }


    }

    private boolean isSafe(int r, int c, int n) {

        // check if queen is placed column up
        for(int i = 0; i < r; i++){

            if(board[i][c] == 1) return false;

        }

        // check if queen is placed diagonal up left
        int i = r, j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1) return false;
            i--;
            j--;
        }

        // check if queen is placed diagonal up right
        i = r; j = c;
        while(i >= 0 && j < n){
            if(board[i][j] == 1) return false;
            i--;
            j++;
        }
        return true;

    }
}