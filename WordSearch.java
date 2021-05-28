/*
Desc : We check for the presence of the first element of word in the board and search for consecutive
elements, everytime a wrong path is chosen, we backtrack and replace the changes made in the matrix by the original value,
and we continue with the recursive iteration to other path until we achieve target.
Time Complexity : O(3^n)
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
