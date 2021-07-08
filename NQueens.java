//Time Complexity : O(n^n) where n is the dimension of the board
// Space Complexity : O(n^2 + n) where n is the size of the integer board 2d matrix + n times recursive stack of backtracking
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach:  Start with the first row. Place the queen from the 0th row at different postions.
As you fix a valid position, move to the next row and again place the queen in a valid position and move to next row. Repeat this till you get all the
valid positions satisfying the constraint of the queen not attacking its mates horizontally, verticallly or diaognally. Get all such possible combinations
and positions and put the result list into result. we are having isValid function to check if any other queen is not occuring in the same row or in
the same column or in the same diagonal, if not, we are good.  */
// BACKTRACKING
class Solution {
    int[][] board;                                                      // Auxilary space chessboard
    int m;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n){
        result = new ArrayList<List<String>>();
        if(n <= 0){return result;}
        board = new int[n][n];
        m =n;                                                           // Wanna use it globally
        PlaceQueens(0);                                                 // Start placing the queens
        return result;
    }
    private void PlaceQueens(int k){
        if(k == m){                                                                             // If all the rows are done
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < m; i++){
               StringBuilder sb = new StringBuilder();
                for(int j = 0; j < m; j++){
                    if(board[i][j] == 0){
                        sb.append('.');
                    } else {
                        sb.append('Q');
                    }
                }
                temp.add(sb.toString());                                                        // Append the combination to the temp list
            }
            result.add(temp);                                                               // Append the temp list to the result as we have entered one such n queens combination
        }
        for(int i = 0; i < m; i++){                                     // Parse over the columns
        if(isValid(k, i)){                                          // Check if it is a valid position
            board[k][i] = 1;                                        // if yes, mark it as Queen placed
            PlaceQueens(k+1);                                       // Go to the next row to check the columns again
            board[k][i] = 0;                                        // backtrack it to 0 as queen cant be placed here
        }
    }    
    }
    
    private boolean isValid(int r, int c){                                              
        for(int j  = 0; j <= r;  j++){                                          // Check if there is a queen in same column
            if(board[j][c] == 1){return false;}
        }
        int i = r-1; int j = c-1;
        while(i >=0 && j >=0){                                                  // Check if there is queen in left diagonal
            if(board[i][j] == 1){return false;}
            i--;
            j--;
        }
         i = r-1; j = c+1;
         while(i >=0 && j < m){                                                 // Check if there is a queen in right diagonal
            if(board[i][j] == 1){return false;}
            i--;
            j++;
        }  
        return true;                                                            // Valid position
    }
}