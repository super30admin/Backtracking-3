//Time complexity=o(4^(m*n))

class Solution {
    public boolean exist(char[][] board, String word){
        boolean [][] visited = new boolean [board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j <board[0].length;j++){
                if(dfs(board,visited,word,i,j))return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, boolean [][] visited, String word,int i,int j){
        int m=board.length;
        int n=board[0].length;
        //base case
        if(word.length()==0) return true;
        
        //recursive case
        if(board[i][j] == word.charAt(0)){
            visited[i][j]=true;
            if(word.length() == 1) return true;
            
            //look right
            if(j<n-1 && !visited[i][j+1]){
                if(dfs(board,visited,word.substring(1),i,j+1)) return true;
            }
             //look left
            if(j>0 && !visited[i][j-1]){
                if(dfs(board,visited,word.substring(1),i,j-1)) return true;
            }
             //look top
            if(i>0 && !visited[i-1][j]){
                if(dfs(board,visited,word.substring(1),i-1,j)) return true;
            }
             //look top
            if(i<m-1 && !visited[i+1][j]){
                if(dfs(board,visited,word.substring(1),i+1,j)) return true;
            }
            
        }
        visited[i][j]=false;//backtrack
        return false;
    }
}