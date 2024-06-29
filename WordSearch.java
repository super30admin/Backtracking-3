//Time complexity - O(4^m) 
//Space Complexity -  O(m) -> m - length of the word - recursive stack 
class Solution {
    int m;
    int n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0){
            return false; 
        }
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board,0,word,i,j)){
                        return true;
                    }
                }

            }
        }
        return false;
        
    }
    private boolean backtrack(char[][] board, int index, String word, int row, int col){
        //base 
         if(index == word.length()){
            return true;
        }
        if(row < 0 || row == m || col < 0 || col == n || board[row][col] == '#' || board[row][col] != word.charAt(index)){
            return false;
        }
       
        //logic
        if(board[row][col] == word.charAt(index)){
            char temp = board[row][col];
            //action
            board[row][col] = '#';
            //recurse
            for(int[] dir : dirs){
                int nr = dir[0] + row;
                int nc = dir[1] + col; 
                if(backtrack(board,index + 1, word, nr, nc)){
                    return true;
                }



            }
            //backtrack
            board[row][col] = temp;
        }
        
        return false;
    }
}
