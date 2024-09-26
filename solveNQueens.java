/* 51. N-Queens
Time Complexity: O(n!) there are n possibilities to put the first queen, not more than n, (n-2) possible options to put the second queen, not more than n(n-2)(n-4) for the third one etc. in total that result to O(n!) time complexity.
Space Complexity: O(n) the result

*/

class Solution {
    List<List<String>> result = new ArrayList<>();
    // a list of lists where each list is a possible solution
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];

        placeQueens(board, 0, n); // start from row '0'

        return result;
    }

    private boolean placeQueens(int[][] board, int row, int n){
        //Base Case
        // if it is a valid solution, add to the result list
        //last row
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuilder s = new StringBuilder();
                for(int j = 0; j<n; j++){
                    if(board[i][j] == 1)
                        s.append('Q');
                    else
                        s.append('.');
                }
                temp.add(s.toString());
            }
            result.add(temp);
            return false;
        }


        //Logic, iterate over all the columns say for row '0'
        for(int i=0; i<n; i++){
            // place a queen at a particular column within a row
            if(isSafe(board, row, i)){
                board[row][i] = 1;
                placeQueens(board, row+1, n);
            }
            //if it is not safe, then backtrack, make it 0 again
            board[row][i] = 0;
        }
        return false;
    }


    private boolean isSafe(int[][] board, int row, int col){   // 2,1
        // if queen is present in the same column, not safe to place queen
        for(int i=0; i<row; i++){
            if(board[i][col] == 1)
                return false;
        }

        // top left
        int r = row-1;
        int c = col-1;
        while(r>=0 && c>=0){
            if(board[r][c] == 1)
                return false;
            r--;
            c--;
        }

        //top right
        r = row-1;
        c = col+1;

        while(r>=0 && c<board[0].length){
            if(board[r][c] == 1)
                return false;

            r--;
            c++;
        }
        return true;
    }
}
