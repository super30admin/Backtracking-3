import java.util.ArrayList;

// Time Complexity: O(n!) every row we have atmost n-2 , n-4 .. decisions to make
// Space Complexity: O(n*n) + O(n) (space for queen board + stack space)- > O(n^2)
public class NQueens {
    List<List<String>> result;
    boolean [][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0)
            return result;
        
        board = new boolean[n][n];
        
        backtrack(0);
        
        return result;
    }

    // we always pass row since we need to check if it is safe to place
    // queen in above rows and all columns
    private void backtrack(int row)
    {
        // base case
        if(row == board.length) // all rows queens were able to be placed
        {
            // convert the board state to string result
            List<String> rows = new ArrayList<>();
            for(int i = 0 ;i < board.length; i ++)
            {
                StringBuilder sb = new StringBuilder(); // because result contains string rows
                for(int j = 0 ; j < board.length; j++)
                {
                    if(board[i][j] == true)
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                // add row to list 
                rows.add(sb.toString());
            }
            result.add(rows);
        }

        // logic
        for(int j = 0 ; j < board.length; j++) // evalute keep queen in all columns
        {
            if(isSafe(row, j))
            {
                board[row][j] = true;
                backtrack(row+1);
                board[row][j] = false; //backtrack current option to evaluate next
            }
        }
    }

    private boolean isSafe(int r, int c)
    {
        // 1. Check for all above rows and same column
        for(int i = r ; i >= 0 ; i--)
        {
            if(board[i][c] == true) // already see
                return false;
        }

        // 2. Check for upper left diagonal if any queen present
        int i = r, j = c;
        while(i >= 0 && j>= 0)
        {
            if(board[i][j] == true)
                return false;
            i--;
            j--;
        }

        // 3. Check for upper right diagonal if any queen present, reset i and j
        i = r;
        j = c;
        while(i >=0 && j < board.length)
        {
            if(board[i][j] == true)
                return false;
            i--;
            j++;
        }

        // no issues faced, place queen at r and c
        return true;
    }
}
