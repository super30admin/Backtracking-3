//TC :M*N*4^L(L is the length of the string)
//SC: O(L) stack space
class Problem2 {
    //navigate horizontal or vertically
    int [][] dirs;
    boolean found ;
    public boolean exist(char[][] board, String word) {
        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        this.found = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!this.found){
                    dfsHelper(board,word,0,i,j);
                }else{
                    return this.found;
                }

            }
        }
        return this.found;
    }


    public void dfsHelper(char[][] board, String word,int idx,int i,int j) {
        //base case when index becomes equal to the length of the String
        if(idx == word.length()){
            this.found = true;
            return;
        }


        if(i<0 || j<0 || i>=board.length || j>=board[0].length ||  board[i][j] != word.charAt(idx)){
            return;
        }

        //we need to find the next char
        char cc = word.charAt(idx);
        board[i][j] = '#';//marked as visited
        for(int [] dir:dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfsHelper(board,word,idx+1,r,c);
            if (this.found) return;


        }
        board[i][j] = cc;//backtrack



    }
}