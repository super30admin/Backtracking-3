
class WordSearch {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        solveQueensHelper(board, 0);
        return result;
    }

    private void solveQueensHelper(boolean[][] board, int row)
    {
        // base
        if(row == board.length)
        {
            List<String> list = new ArrayList<>();
            for(int i = 0; i < board.length; i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < board.length; j++)
                {
                    if(board[i][j])
                    {
                        sb.append("Q");
                    }
                    else
                    {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
        }

        // logic
        for(int col = 0; col < board.length; col++)
        {
            if(isSafeToPlace(board, row, col))
            {
                //action
                board[row][col] = true;
                // recurse
                solveQueensHelper(board, row+1);
                // backtrack
                board[row][col] = false;
            }
        }
    }

    private boolean isSafeToPlace(boolean[][] board, int row, int col)
    {
        // is safe - colum up
        for(int i = 0; i < row; i++)
        {
            if(board[i][col])
            {
                return false;
            }
        }

        // is safe - diagonal up right
        int i = row, j = col;
        while(i >= 0 && j < board.length)
        {
            if(board[i][j]) return false;
            i--;
            j++;
        }

        // is safe - diagonal up left
        i = row; j = col;
        while(i >= 0 && j >= 0)
        {
            if(board[i][j]) return false;
            i--;
            j--;
        }
        return true;
    }
}