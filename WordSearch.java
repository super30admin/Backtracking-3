// Time Complexity : O(MXN X 3^L)
// Space Complexity : O(L) L is length of word
// Did it run on Leetcode: Yes

class Solution {
    int m,n;
    int dirs[][];
    public boolean exist(char[][] board, String word) {
        if(board.length == 0){
            return false;
        }
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean backtrack(char[][] board,String word,int row,int col, int index ){
        if(index == word.length()){
            return true;
        }
        if(row>=m || row<0 || col>=n || col<0 || board[row][col] == '#'){
            return false;
        }
        if(board[row][col] == word.charAt(index)){
            char ch = board[row][col];
            board[row][col] = '#';
            for(int[]dir : dirs){
                int nr = dir[0];
                int nc = dir[1];
                if(backtrack(board,word,nr+row,nc+col,index+1)){
                    return true;
                }
            }
            board[row][col] = ch;
        }
        return false;
    }
}