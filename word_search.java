// Time 0(4^mn)
// Space O(mn)

class Solution {
    boolean[][] visited;
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    boolean flag=false;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char ch = board[i][j];
                if(ch==word.charAt(0)){
                    visited[i][j]=true;
                    helper(i, j, board, word, 1);
                    if(flag==true){
                        return true;
                    }
                    visited[i][j]=false;
                }
            }
        }
        return false;
        
    }

    public void helper(int i, int j, char[][] board, String word, int idx){
        //base
        if(idx==word.length()){
            flag=true;
            return;
        }

        //logic
        for(int[] dir: dirs){
            int row = dir[0]+i;
            int col = dir[1]+j;
            if(row>=0 && row<m && col>=0 && col<n && board[row][col]==word.charAt(idx) && !visited[row][col]){
                visited[row][col]=true;
                helper(row,col,board,word,idx+1);
                visited[row][col]=false;
            }
        }
    }


}
