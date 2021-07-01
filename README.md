# Backtracking-3

## Problem1 
N Queens(https://leetcode.com/problems/n-queens/)

class Solution {
    
    //Time Complexity = Exponential of factorial
    // Space Complexity = O(n^2)
    
    int[][] board; 
    List<List<String>> result; 
    
    public List<List<String>> solveNQueens(int n) {
        
        board = new int[n][n];
        result = new ArrayList<>(); 
        
        backtrack(0,n);
        
        return result; 
    }
    
    private void backtrack(int r, int n){
        //base
        if(r == n){
            List<String> li = new ArrayList<>(); 
            
            for(int i = 0; i < n; i++){
                StringBuilder sn = new StringBuilder(); 
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 1){
                        sn.append('Q');
                    }else{
                        sn.append('.');
                    }
                }
                li.add(sn.toString());
            }
            result.add(li);
        }
        
        
        
        
        //logic
        for(int j = 0; j < n; j++){
            if(isSafe(r,j,n)){
                //action
                board[r][j] = 1;
                
                //recursion
                backtrack(r+1, n);
                
                //backtrack
                board[r][j] = 0;
                
            }
        }
    }
    
    private boolean isSafe(int r, int c, int n){
        //column check
        for(int i = 0; i < r; i++){
            if(board[i][c] == 1) return false; 
        }
        
        int i = r;
        int j = c;
        //left diagonal check
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1) return false;
            i--; j--;
        }
        
        i = r;
        j = c;
        
        //right diagonal check
        while(i >= 0 && j < n){
            if(board[i][j] == 1) return false;
            i--; j++; 
        }
        
        return true; 
    }
}



## Problem2
Word Search(https://leetcode.com/problems/word-search/)

//Time Complexity = N * 3^l where N = size of matrix and l = length of string
//Space Complexity = O(N^2)
class Solution {
    int[][] dirs; 
    int m;
    int n; 
    public boolean exist(char[][] board, String word) {
        
         if(board == null || board.length == 0 || board[0].length == 0 || board[0] == null) return false;
        
        dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
        m = board.length; 
        n = board[0].length; 
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                     if(backTrack(board,word, 1 ,i,j)) return true;
                }
            }
        }
        return false; 
    }
    
    private boolean backTrack(char[][] board, String word, int index, int r, int c){
        //base
        if(index == word.length()) return true; 
        
        //logic
        char temp = board[r][c];
        board[r][c] = '#'; 
        
        for(int[] dir:dirs){
            int i = r + dir[0];
            int j = c + dir[1]; 
            
            if(i >= 0 && j >= 0 && i < m && j < n && board[i][j] == word.charAt(index)){
                if(backTrack(board, word, index + 1, i , j)) return true;
            }
        }
        
        //backtrack
        board[r][c] = temp;
        
        return false; 
        
    }
}