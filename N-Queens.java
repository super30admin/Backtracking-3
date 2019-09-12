/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
*/


class Solution {
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        
        int[][] board = new int[n][n];
        
        placeQueens(board, 0, n);
        
        return result;
    }
    
    boolean placeQueens(int[][] board, int row, int n){
        
        // base case when last row is reached
        
        if(row == n){
            
            List<String> temp = new ArrayList<String>();
            
            for(int i = 0; i < n; i++){
                
                String s = new String();
                
                for(int j = 0; j < n; j++){
                    
                    if(board[i][j] ==  1)   s += "Q";
                    else s += ".";
                }
                
                temp.add(s);
            }
            
            result.add(temp);
        }
        
        for(int i = 0; i < n; i++){
            
            if(isSafe(board, row, i)){
                
                board[row][i] = 1;
                
                if(placeQueens(board, row + 1, n))  return true;   
                
                board[row][i] = 0;
            }
            
       }
        
        return false;
        
    }
    
    public boolean isSafe(int[][] board, int row, int col){
        
        for(int i = 0; i < row; i++){
            
            if(board[i][col] == 1)  return false;
            
        }
        
        int r = row - 1;
        int c = col - 1;
        
        while(r >= 0 && c >= 0){
            
            if(board[r][c] == 1) return false;
            r--;
            c--;
        }
        
        r = row - 1;
        c = col + 1;
        
        while(r >= 0 && c <= board[0].length - 1){
            
            if(board[r][c] == 1)    return false;
            r--;
            c++;
        }
        
        return true;
    }
}