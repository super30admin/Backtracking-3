class WordSearch {
    /*

    TC: O(m * n * 3^L)
    SC: O(L) where L is length of word
    
    */
    int dirs[][];
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0) return false;

        dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(backtrack(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board,String word,int row,int col ,int index){
        //base
        if(index==word.length()-1){
            return board[row][col]==word.charAt(index);
        }
        //logic
        if(board[row][col]==word.charAt(index)){
            char capturedElement=board[row][col];
            board[row][col]='#';
            for(int dir[]:dirs){

                int r=row+dir[0];
                int c=col+dir[1];

                if(r>=0 && r<board.length && c>=0 && c<board[0].length && board[r][c]!='#'){
                    if(backtrack(board,word,r,c,index+1)){
                        return true;
                    }
                }
            }
            board[row][col]=capturedElement;
        }
        return false;
    }
}