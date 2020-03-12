//o(m*4^n) time and o(n) space
//passed all leetcode cases
//used backtracking discussed in class

class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if(board == null||board.length==0||word.length()==0){
            return false;
        }
        m=board.length;
        n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,i,j)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word,int i,int j){
        if(i<0||j<0||i>=m||j>=n||board[i][j]=='#') return false;

        int[][]dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        if(board[i][j]==word.charAt(0)){
            if(word.length()==1) return true;
            char prev = board[i][j];
            board[i][j] = '#';
            for(int[]dir:dirs){
                int r = dir[0]+i;
                int c = dir[1]+j;
                if(dfs(board,word.substring(1),r,c)) return true;
            }
            board[i][j]=prev;

        }
        return false;
    }
}