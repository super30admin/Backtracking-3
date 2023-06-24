/*
THREE THINGS IN TIME COMPLEXITY
1. 2 ^(N ^2) = you have nxn cells and each cell has 2 choices which is n(n-2) x(n-4) x ... = n! = N!
2. 3N = To check safe condition
3. xN^2 = when we copy the result into sub result

Point 2 and point 3 are less than N!
Thus, Time Complexity:  N!

N for sub result which is temporary 
N^2 for total result
Space Complexity: n + n^2 = n^2 
 */


class Solution {
    private static final char QUEEN = 'Q', EMPTY='.';
    
    private char board[][];
    private List<List<String>> result;
    private int n;
    
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        
        board = new char[n][n];
        result = new ArrayList<>();
        
        for(char[] row: board){
            Arrays.fill(row, EMPTY);
        }
        
        nQueen(0);
        return result;
    }
    
    private void nQueen(int row){
        //base case
        if(row == n){
            List<String> boardList = new ArrayList<>();
            for(char[] boardRow: board){
                boardList.add(new String(boardRow)); // char array is being converted to a string and being added to the boardList
            }
            
            result.add(boardList);
        }
        
        
        for(int col=0; col<n; col++){
            if(isSafe(row,col)){
                board[row][col] = QUEEN;
                nQueen(row+1);
                board[row][col] = EMPTY;
            }
        }
    }
    
    private boolean isSafe(int row, int col){
        return isSafeCol(row, col) && 
            isSafeLeftUpperDiagonal(row, col) && 
            isSafeRightUpperDiagonal(row,col);
    }
    
    private boolean isSafeCol(int row, int col){
        --row;
        while(row>=0){
            if(board[row][col]==EMPTY){
                --row;
            }
            else
                return false;      
        }
        return true;
    }
    
    private boolean isSafeLeftUpperDiagonal(int row, int col){
        --row;
        --col;
        while(row>=0 && col>=0){
            if(board[row][col]==EMPTY){
                --row;
                --col;
            }
            else
                return false;      
        }
        return true;
    }
    private boolean isSafeRightUpperDiagonal(int row, int col){
        --row;
        ++col;
        while(row>=0 && col<n){
            if(board[row][col]==EMPTY){
                --row;
                ++col;
            }
            else
                return false;      
        }
        return true;
    }
}