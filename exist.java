//TC - Exponential
//SC - O(L) where L is the length of the word
class Solution {
    boolean [][] visited;
    int finalCount=0;
    int[][] drs = {{-1,0},{1,0},{0,1},{0,-1}};
    int n,m;
    public boolean exist(char[][] board, String word) {
         n = board.length;
         m = board[0].length;
        
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dfs(board,word,0,i,j)){
                     return true;
                }
            }
        }

        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int index,int r,int c){
        //base
        if(index==word.length()) return true;
        if(r==n || r<0 || c<0 || c==m || board[r][c]=='#') return false;
        
        //logic
        if(board[r][c]==word.charAt(index)){
            
                //action
            char ch = board[r][c];
            board[r][c] = '#';
                //recurse
            for(int[] dr : drs){
                int nr = dr[0]+r;
                int nc = dr[1]+c;


                if(dfs(board,word,index+1,nr,nc)) return true;
                
            }
                //backtrack
            board[r][c] = ch;
        }    

        
        return false;
    }
}