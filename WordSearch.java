//Time Complexity : O(m*n*(3^l))
//Space Complexity : O(l)  , l=length of word
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        int[][] dirs=new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(backtrack(board,word,0,dirs,i,j)){
                        return true;
                    }
                } 
            }       
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word,int i, int[][] dirs,int r, int c){
        //base
        if(i==word.length()){
            return true;
        }
        if(r<0 || r==board.length || c<0 || c==board[0].length || board[r][c]!=word.charAt(i) || board[r][c]=='*'){
            return false;
        }
        board[r][c]='*';
        //logic
        for(int[] dir:dirs){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(backtrack(board,word,i+1,dirs,nr,nc)){
                return true;
            }
        }
        board[r][c]=word.charAt(i);
        return false;
    }
}