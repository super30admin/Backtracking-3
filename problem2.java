//Time Complexity : O(m*n*3^l), m -> Number of rows, n -> Number of columns, l -> Size of string
// Space Complexity : O(l)
class Solution {
    public boolean exist(char[][] board, String word) {
        
        if(board==null) return false;
        
        for(int i=0; i<board.length; i++){
            
            for(int j=0; j<board[0].length; j++){
                
                if((board[i][j]== word.charAt(0)) && dfs(board, i, j, word, 0))
                    return true;
                
            }
            
        }
        
        return false;
        
    }
    
    
    public boolean dfs(char[][] board,int i, int j, String word, int index){
        
        //boundary case
        
        if(i<0 || i>=board.length || j<0 || j>= board[0].length || word.charAt(index)!= board[i][j]) return false;
        
        //base case
        if(index== word.length()-1) return true;
        
        char temp= board[i][j];
        board[i][j]= ' ';
        
        boolean found= dfs(board, i+1, j, word, index+1) || dfs(board, i-1, j, word, index+1) || dfs(board, i, j+1, word, index+1) || dfs(board, i, j-1, word, index+1);
        
        board[i][j]= temp;
        
        return found;    
        
    }