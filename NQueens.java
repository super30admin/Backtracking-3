/*
Desc : We check for every position of Queen in the board at every row ,
whenever all th equeens are not able to accomodate, we backtrack and re position the queen at base level.
Time Complexity : O(n!)
Space Complexity : O(1)
*/

class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length; n = board[0].length;
        if(word.length()==0) return true;
        if(board == null || board.length == 0) return false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board,String word,int i,int j,int index){
        //base
        if(i<0||j<0||i==m||j==n) return false;
        if(index == word.length()) return true;
        //logic
        int [][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
        if(word.charAt(index)==board[i][j]){
            //action
            char temp = board[i][j];
            board[i][j] = '#';
            for(int [] dir:dirs){
                int r=i+dir[0];
                int c = j + dir[1];
                if(backtrack(board,word,r,c,index+1)) return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
}
