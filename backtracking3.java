//1.N Queens
//Time Complexity -> N(4^n)
//Space Complexity -> n
class Solution {
    boolean[][] board;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList();
        this.board = new boolean[n][n];
        helper(board,0,n);
        return result;
        
    }

    private void helper(boolean[][] board,int row,int n){
        //base case
        if(row == n){
            List<String> path = new ArrayList<>();
            for(int i = 0;i < board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j< board[0].length;j++){
                    if(board[i][j] == true){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                path.add(sb.toString());
            }
            result.add(path);
        }

        //logic
        for(int j = 0;j<n;j++){
            if(isSafe(board,row,j)){ //basically checking if we keep the queen safely at board[r][j]
               //action
               board[row][j] = true;
               //recurse
               helper(board,row+1,n); //now after putting one queen we put the nextqueen pn the next row
               //backTrack
               board[row][j] = false;
            }
        }

    }

    private boolean isSafe(boolean[][] board,int row,int col){
        //directly up
        for(int i = 0;i<=row;i++){
            if(board[i][col] == true) return false;
        }
        //diagonally left
        int i = row;
        int j = col;
        while(i >=0 && j >=0){
            if(board[i][j] == true) return false;
            i--;
            j--;
        }
        //diagonally right
        int k = row;
        int t = col;
        while(k >=0 && t < board[0].length){
            if(board[k][t] == true) return false;
            k--;
            t++;
        }

        return true;
    }
}

//2. word Search
//Time Complexity -> n*m*(4^n*m)
//Space Complexity -> n*m
class Solution {
    boolean flag;
    int nRows;
    int nCols;
    private int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.flag = false;
        this.nRows = board.length;
        this.nCols = board[0].length;
        this.dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}}; //left up right down 
        for(int i = 0;i<nRows;i++){
            for(int j = 0;j<nCols;j++){
                if(!flag){
                    dfs(board,word,0,i,j);
                }
            }
        }
        return flag;
        
    }

    private void dfs(char[][] board, String word,int idx,int r,int c){
        //base case
        if(idx == word.length()) {
            flag = true;
            return;
        }
        if( r < 0 || c < 0 || r >= nRows || c >= nCols || board[r][c] =='#' ) return;
        //logic
        if(word.charAt(idx) == board[r][c]){
            //means we have got the character at board hence we will call dfs on board[i][j]
            //action
            board[r][c] = '#';
            //recurse
            for(int[] dir : dirs){
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if(!flag){
                    dfs(board, word, idx+1, nr, nc);
                }
                
                if(flag == true) break;
            }
            //backTrack
            board[r][c] = word.charAt(idx);
        }
    }
}