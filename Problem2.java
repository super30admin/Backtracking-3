public class Problem2 {
    //t.c ->exponential O(m*n)*3^L
    //s.c ->O(l)
    class Solution {
        int m,n;
        int[][] dirs;
        public boolean exist(char[][] board, String word) {
            if(board == null || board.length == 0){
                return false;
            }
            m = board.length;
            n = board[0].length;
            dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
            for(int i = 0;i<m;i++){
                for(int j = 0;j<n;j++){
                    //find the first char of word and start backtrack from there
                    if(board[i][j] == word.charAt(0)){
                        if(backtrack(board,i,j,word,0)){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        private boolean backtrack(char[][]board , int row, int col, String word, int index){
            //base
            if(index == word.length()){
                return true;
            }
            if(row <0 || row == m || col<0||col ==n || board[row][col]=='#'){
                return false;
            }


            //logic
            //match the cell value with index at word
            if(board[row][col] == word.charAt(index)){
                //action
                char temp = board[row][col];
                //visited
                board[row][col] = '#';
                //recurse
                for(int[] dir : dirs){
                    int nr = row +dir[0];
                    int nc = col + dir[1];
                    //go in each direction and if its valid just return true;
                    if(backtrack(board,nr,nc,word,index+1)){
                        return true;
                    }
                }
                //backtrack
                board[row][col] = temp;
            }
            return false;
        }
    }
}
