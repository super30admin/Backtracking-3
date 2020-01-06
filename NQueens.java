/*Time Complexity: O(n!) 
Space Complexity: O(n)
Approach: There are n ways to put the first queen, (n-2) possible options to put the second queen, and so on.
*/

class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];

        placeQueens(board, 0, n);

        return result;
    }

    private boolean placeQueens(int[][] board, int row, int n){
        //Base Case
        //if it is a valid solution, add to the result list
        //terminating condition is the last row
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


        //Logic,
        for(int i=0; i<n; i++){
            // place a queen at a particular column within a row
            if(isSafe(board, row, i)){
                board[row][i] = 1;
                placeQueens(board, row+1, n);
            }
            //no safe, so backtrack and make it 0 again
            board[row][i] = 0;
        }
        return false;
    }


    private boolean isSafe(int[][] board, int row, int col){
        // two queen in the same columns is not safe
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