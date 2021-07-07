//Time Complexity : O(N*3^L). Here N = m*n and L is the length of the word
//Space Complexity : O(L). recursive stack takes O(L) space.

/*
Using the DFS traversal visit the ajacent cells in the board. After each charcter is matched, store the charcter and mark it as visited(her '#' is used).
 If at any instance if the character is not pesent mark it unvisited and backtrack to the previous matched character and continue the traversal.
 */

class Solution {
    int m,n;
    public boolean exist(char[][] board, String word) {
        if(board.length==0||board==null){
            return false;
        }
        n = board.length;
        m = board[0].length;
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //helper function is called for each cell in board
                if(backtrack(board,word,i,j,index)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][]board, String word,int r,int c,int index){
         if(index==word.length()){
             return true;
         }
        if(r<0 || r==n || c<0 || c==m || board[r][c]== '#'){
            return false;
        }
        //if the character matches search its nehigbouring cells to find the next characters
        if(board[r][c]==word.charAt(index)){
            //mark it as visited
            char temp = board[r][c];//save it to use it for backtracking
            board[r][c] = '#';
            int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
            for(int[] dir : dirs){
                int row = r + dir[0];
                int col = c + dir[1];
                if(backtrack(board,word,row,col,index+1)){
                    return true;
                }
            }
              //if its not the right character backtrack to go to another direction by restoring the original value and to mark unvisited
        board[r][c] = temp;
        }
      return false;
    }
}