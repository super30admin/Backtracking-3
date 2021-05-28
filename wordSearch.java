// Time complexity - O(mxn)
// Space complexity - O(mxn) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    boolean result;
    public boolean exist(char[][] board, String word) {
        
        if(board.length == 0 || board == null || board[0].length == 0 || word.equals("")){
            
            return false;
        }
        
        int r = board.length;
        int c = board[0].length;
        result = false;
        
        
        for(int i = 0; i < r; i ++){
            
            for(int j = 0; j < c; j ++){
                
                int k = 0;
                char ch = word.charAt(k);
                
                if(board[i][j] == ch && k == word.length() - 1){
                    
                  //  k ++;
                    result = true;
                    return result;
                  //  vis[i][j] = true;
                    
                  //  dfs(r, c, ndx, ndy,board, word, k, vis  );
                }
                
               else if(board[i][j] == ch && k < word.length()){
                    boolean[][] vis = new boolean[r][c];
                    
                    k ++;
                    
                    vis[i][j] = true;
                    
                    dfs(r, c, i,j,board, word, k, vis  );
                    
                    if(result == true){
                        
                        return result;
                    }
                }
            }
        }
        return false;
    }
    
    private void dfs(int r, int c, int i, int j, char[][] board, String word,int k, boolean[][] vis){
        
        int[] dx = new int[]{-1,0,0,1};
        int[] dy = new int[]{0,1,-1,0};
        
        for(int m = 0; m < 4; m ++){
            
            int ndx = i + dx[m];
            int ndy = j + dy[m];
            
            if(isValid(r, c, ndx, ndy) && vis[ndx][ndy] == false && k < word.length()){
                
                char ch = word.charAt(k);
                
                if(board[ndx][ndy] == ch && k == word.length() - 1){
                    
                  //  k ++;
                    result = true;
                    return;
                  //  vis[i][j] = true;
                    
                  //  dfs(r, c, ndx, ndy,board, word, k, vis  );
                }
                
               else if(board[ndx][ndy] == ch ){
                    
                    k ++; //action
                    
                    vis[ndx][ndy] = true; //action
                    
                    dfs(r, c, ndx, ndy,board, word, k, vis  ); //recurse
                   vis[ndx][ndy] = false; //backtrack on action
                   
                   k --; //backtrack on action
                }
                
            
              
                
            }
             //k --;
        }
        
       
        
    }
    
    private boolean isValid(int r, int c, int i, int j){
        
        if(i < r && j < c && i > -1 && j > -1){
            
            return true;
        }
        
        return false;
    }
}