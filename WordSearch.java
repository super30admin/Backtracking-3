//Time Complexity:O(m*n*3^L) - L - length of string
//Space Complexity:O(L)
//Approach: Backtracking with dfs 
class Solution {
    int m,n;
    boolean flag;
    String word;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.word = word;
        this.dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!flag){
                    dfs(board,i,j,0);
                }
            }
        }
        return flag;
    }

    private void dfs(char[][] board,int i,int j,int index){
        //base case
        //end of word reached, match
        if(index == word.length()){
            flag = true;
            return;
        }
         //boundary check
         if(i<0 ||j<0||i==m ||j==n) return;
        //letter does not match
        if(board[i][j]!=word.charAt(index)) return;
       
       

        //logic
        //mark board as visited
        board[i][j]='#';
        for(int[] dir:dirs){
            int  row = i+dir[0];
            int col = j+dir[1];

            dfs(board,row,col,index+1);
        }
        //restore char from # to original value;
        board[i][j]= word.charAt(index);

    }
}