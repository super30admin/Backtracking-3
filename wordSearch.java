// Time Complexity : O(m*n)* 3 ^ L, L= length of string
// Space Complexity : O(n) n= length of string
class Solution {
    int[][] dirs;
    int m, n;
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0) return false; 
        dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}}; //U D L R
        m= board.length;
        n= board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board,word, 0, i, j)){
                    return true;
                }
            }
        }
        
        return false;
       
    }
    
    private boolean backtrack(char[][] board,String word,int index, int row, int col){
        //base
        if(index==word.length()) return true;
        
        if(row<0 || col<0 || row==m || col==n || board[row][col]=='#'){
            return false;
        }
        
        //logic
        if(board[row][col]==word.charAt(index)){
            char ch=board[row][col];
            board[row][col] = '#';
        
           for(int[] dir:dirs){
                int nr=row+dir[0];
                int nc=col+dir[1];
                if(backtrack(board, word, index+1, nr, nc)){
                    return true;
                }
            }
            
            board[row][col] = ch;
        }
        
        return false;
        
    }
}