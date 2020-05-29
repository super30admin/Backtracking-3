//Prob-1: N-Queens
/**
TC= O(n!)
Sc= O(m*n) = n num of rows and cols
Backtrack solution: try to palce a queen starting from a particular row and each time check if it is a valid move. If valid, keep placing until the end of the board and backtrack to see if there are other combinations availaible. 
*/
class Solution {
    int m;
    List<List<String>> result;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        
        m = n;
        result = new ArrayList<>();
        board = new int[m][m];
        placeQueen(0); 
        
        return result;
    }
    // checking all the directions to check if a queen can be placed at a particula index
    private boolean isSafe(int r, int c){
        
        // same row
        for( int i=0; i <=r; i++){
            if(board[i][c] == 1) return false;
        }
        
        // up right diagonal
        int upRow = r-1; int upCol = c+1;
        while(upRow >=0 && upCol < m){
            if(board[upRow][upCol] ==1)return false;
            upRow--;
            upCol++;
        }
        //up left diagonal
        int UpLeftRow = r-1; int upLeftCol = c-1;
        while(UpLeftRow >= 0 && upLeftCol>=0){
            if(board[UpLeftRow][upLeftCol] == 1) return false;
            upLeftCol--;
            UpLeftRow--;
        }
        

        
        return true;
    }
    
    private void placeQueen(int curRow){
        //base( create a temp array that will hold the resultant row and fill it int the result array)
        if(curRow == m){ // if it is end of the board
            List<String> tempBoard = new ArrayList<>();
            
            for(int i=0; i<m; i++){
                StringBuilder tempRowString = new StringBuilder();   
                for(int j=0; j<m; j++){
                    if(board[i][j] == 0){
                        tempRowString.append('.');
                    }else{
                        tempRowString.append('Q');
                    }
                }
                tempBoard.add(tempRowString.toString());
            }
            result.add(tempBoard);
        } 
        //recurse & logic
        for(int i = 0; i<m; i++){
            
            if(isSafe(curRow, i)){
                board[curRow][i] = 1;
                
                placeQueen(curRow+1);
                //backtrack
                board[curRow][i] = 0;
            }
        }
        
        
        
    }
}









// Prob-2: Word Search
/**
TC = m*n*4^L , where l is the len of the string. 4^L because each character has to go 4 directions, L because each character in the string will be looked up  4 times in the board.
SC= height of the stack, which will go upto len of the given string
Backtrack solution: Itearate over the board in the DFS manner. If the current char in the board matches the the current index that we are at in the "word" string, then explore that path further and mark it visited or replace it with a special charachter. If it is not the case, then backtrack and retrun the recently visited character in the board to its original state.
*/
class Solution {
    int m, n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board[0].length == 0) return false;
        
        // itearting over the board
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfsWithBacktrack(board, word, i, j)) return true; //while iterating the board in dfs manner, at any point if our current path matches the word string, return true
            }
        }
        
        return false;
        
    }
    
    private boolean dfsWithBacktrack(char[][] board, String word, int i, int j){
        
        //base
        if( i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') return false;
        // if(word.length() == 0) return true;
        //recurse and logic (for all 4 directions)
        
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        
        if(board[i][j] == word.charAt(0)){
            char prev = board[i][j]; // storing the the recent visited path
            board[i][j] = '#'; // marking the visited path with a special char
            if(word.length() == 1) return true; // edge case where the len of the given string is 1 only
            for(int[] dir: dirs){
                int r=dir[0]+i;
                int c=dir[1]+j;
                if(dfsWithBacktrack(board,word.substring(1), r, c)) return true; // if the cur path matches the word string, return true
            }
            board[i][j] = prev;
            
        }
        
        return false;
    }
}



// Prob-2: Word Search with using substring
/**
TC = m*n*4^L , where l is the len of the string. 4^L because each character has to go 4 directions, L because each character in the string will be looked up  4 times in the board.
Backtrack solution: Itearate over the board in the DFS manner. If the current char in the board matches the the current index that we are at in the "word" string, then explore that path further and mark it visited or replace it with a special charachter. If it is not the case, then backtrack and retrun the recently visited character in the board to its original state.
*/
class Solution {
    // int index;
    public boolean exist(char[][] board, String word) {
        if(board == null || board[0].length == 0) return false;
        // index =0;
        // itearting over the board
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfsWithBacktrack(board, word, i, j,0)) return true; //while iterating the board in dfs manner, at any point if our current path matches the word string, return true
            }
        }
        
        return false;
        
    }
    
    private boolean dfsWithBacktrack(char[][] board, String word, int i, int j, int index){
        
        //base
        if(index >= word.length()) return true;
        if( i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') return false;
        //recurse and logic (for all 4 directions)
        
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        if(board[i][j] == word.charAt(index)){
            
            char prev = board[i][j]; // storing the the recent visited path
            
            
            board[i][j] = '#'; // marking the visited path with a special char
            // if(index == word.length()) return true; // edge case where the len of the given string is 1 only
            for(int[] dir: dirs){
                int r=dir[0]+i;
                int c=dir[1]+j;
                if(dfsWithBacktrack(board,word, r, c, index+1)) return true; // if the cur path matches the word string, return true
                
            }
            board[i][j] = prev; // after exploring all 4 directions of current char, return to its prev state
            
        }
        
        return false;
    }
}
