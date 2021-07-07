// 51.

//run time - O(n!)
//space - O(n^2) for the board, and O(n) for the call stack

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                board[i][j] = '.';
            }
        }
        
        helper(board, result, n, 0);
        
        return result;
    }
    
    private void helper(char[][] board, List<List<String>> result, int N, int row) {
        //base
        if(N == 0)
        {
            addResult(board, result);
            return;
        }
        //logic
        //in each row, check if a cell is safe, if so place and recurse then backtrack
        for(int j = 0; j < board[0].length; j++)
        {
            if(checkSafe(board, row, j))
            {
                board[row][j] = 'Q';
                helper(board, result, N - 1, row + 1);
                board[row][j] = '.';
            }
        }
    }
    
    private void addResult(char[][] board, List<List<String>> result) {
        List<String> solution = new ArrayList<>();
        for(int i = 0; i < board.length; i++)
        {
            String row = "";
            for(int j = 0; j < board[0].length; j++)
            {
                row += board[i][j];
            }
            solution.add(row);
        }
        result.add(solution);
    }
    
    private boolean checkSafe(char[][] board, int row, int column) {
        //check column
        for(int i = 0; i < board.length; i++)
        {
            //check all the previous rows whether a queen is in that column if so return false
            if(board[i][column] == 'Q')
            {
                return false;
            }
        }
        
        //first diagonal
        //prev element in this diagonal in prev row, prev column
        int i = row - 1;
        int j = column - 1;
        while(i >= 0 && j >= 0)
        {
            if(board[i][j] == 'Q')
            {
                return false;
            }
            i--;
            j--;
        }
        
        //second diagonal
        //prev element in this diagonal in prev row, next column
        i = row - 1;
        j = column + 1;
        while(i >= 0 && j < board[0].length)
        {
            if(board[i][j] == 'Q')
            {
                return false;
            }
            i--;
            j++;
        }
        
        return true;
    }
}
