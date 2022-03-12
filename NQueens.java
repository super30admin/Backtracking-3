class Solution {
    
    boolean board[][];
    List<List<String>> results = new ArrayList<>();
    
    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> leftUpperDiag = new HashSet<>();
    Set<Integer> rightUpperDiag = new HashSet<>();
    
    public List<List<String>> solveNQueens(int n) {
        board = new boolean[n][n];
        backtrackingFunc(board, 0, n);
        return results;
    }
    
    
    public void backtrackingFunc(boolean board[][], int row, int n)
    {
        // base case
        if (row == board.length)
        {
            List<String> innerList = new ArrayList<>();
            for(int i=0; i<n; i++)
            {
               StringBuilder sb = new StringBuilder();
                for (int j=0; j<n; j++)
                {
                    if (board[i][j])
                    {
                        sb.append("Q");
                    }
                    else
                    {
                        sb.append(".");
                    }
                }
                
                innerList.add(sb.toString());
            }
            
            results.add(innerList);
        }
        
        
        // recur
        for (int col=0; col<n; col++)
        {
            // place a queen
            if (isSafe(row, col))
            {
                // choose 
                board[row][col] = true;
                rows.add(row);
                cols.add(col);
                leftUpperDiag.add(row - col);
                rightUpperDiag.add(row + col);
                
                // recur
                backtrackingFunc(board, row+1, n);
                
                board[row][col] = false;
                rows.remove(row);
                cols.remove(col);
                leftUpperDiag.remove(row - col);
                rightUpperDiag.remove(row + col);
            }
        }
    }
    
    
    private boolean isSafe(int row, int col)
    {
        return isSafeRowWise(row) && isSafeColWise(col) && isSafeLeftUpperDiag(row, col)
            && isSafeRightUpperDiag(row, col);
    }
    
    private boolean isSafeRowWise(int row)
    {
        return !rows.contains(row);  
    }
    
    private boolean isSafeColWise(int col)
    {
        return !cols.contains(col); 
    }
    
    private boolean isSafeLeftUpperDiag(int row, int col)
    {
        return !leftUpperDiag.contains(row-col);
    }
    
    private boolean isSafeRightUpperDiag(int row, int col)
    {
        return !rightUpperDiag.contains(row + col);
    }
}
