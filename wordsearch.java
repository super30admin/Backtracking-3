# Time complexity:O(m*n)
# Space complexity: 0(m*n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No

class Solution {

    int[] dx = new int[]{-1,0,1,0};
    int[] dy = new int[]{0,1,0,-1};

   public boolean exist(char[][] board, String word) {


       for(int i = 0; i < board.length; i++){
           for(int j = 0; j < board[0].length; j++){
               if(backtrack(board, word, i,j,0)){
                   return true;
               }
           }
       }

       return false;
   }


   private boolean backtrack(char [][]board,String word, int row, int col, int cursor){


       if(cursor == word.length()){
            return true;

       }


       if(isValid(board, row, col) && board[row][col] == word.charAt(cursor)){

           char remember = board[row][col];
           board[row][col] = '$';

           for(int k = 0; k < 4; k++){
               int x = row + dx[k];
               int y = col + dy[k];

           if(backtrack(board, word,x, y, cursor + 1)){
               return true;
           }

           }

           board[row][col] = remember;
       }

       return false;
   }


   private boolean isValid(char[][] board, int i, int j){

    return i >= 0 && i < board.length && j >= 0 && j < board[0].length;

   }
}