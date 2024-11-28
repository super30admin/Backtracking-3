// Approach : DFS Recursion with backtracking 
// Time : M*N * 3^(l) # l - length of the word , # M*N - board
// Space : O(L) # recursion space
class Solution {
    boolean flag;
    int m;
    int n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.flag = false;
        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
        for(int i =0;i<m;i++){
            for (int j =0;j<n;j++){
                if(!flag){
                    dfs(board,i,j,0,word);
                } else{
                    break;
                }
            }
        }
        return flag;
    }

    public void dfs(char[][] board,int i, int j,int index, String word){
        // base case
        if(index == word.length()){
            flag = true;
            return;
        };
        // recursion stop
        if(i<0 || j<0 || i==m || j==n || board[i][j]=='#') return;

        // logic
        if(word.charAt(index)== board[i][j]){
            // action - mark as visited
            board[i][j] = '#';
            // Recurse 4 directions
            for(int [] dir:dirs){
                int nr = i+ dir[0];
                int nc = j+ dir[1];
                dfs(board,nr,nc,index+1,word);
            }
            // backtrack
            board[i][j]=word.charAt(index);
        }

    }
}

// Approach : DFS Recursion with backtracking - boolean based recursion 
// Time : M*N * 3^(l) # l - length of the word , # M*N - board
// Space : O(L) # recursion space
class Solution {
    int m;
    int n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
        for(int i =0;i<m;i++){
            for (int j =0;j<n;j++){
                if(dfs(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,int i, int j,int index, String word){
        // base case
        if(index == word.length()){
            return true;
        };
        // recursion stop
        if(i<0 || j<0 || i==m || j==n || board[i][j]=='#') return false;

        // logic
        if(word.charAt(index)== board[i][j]){
            // action - mark as visited
            board[i][j] = '#';
            // Recurse 4 directions
            for(int [] dir:dirs){
                int nr = i+ dir[0];
                int nc = j+ dir[1];
                if(dfs(board,nr,nc,index+1,word)){
                    return true;
                }
            }
            // backtrack
            board[i][j]=word.charAt(index);
        }
        return false;
    }
}