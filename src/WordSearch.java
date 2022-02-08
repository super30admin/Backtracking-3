/*
// Time Complexity : O(N * 3*L)
// Space Complexity : O(L)

 */
public class WordSearch {
   //dfs backtract
    class Solution {

        boolean flag = false;
        int dirs[][] = new int[][]{{1,0} , {-1,0}, {0,-1}, {0,1}};

        public boolean exist(char[][] board, String word) {
            if(board == null || word.length()==0) return true;
            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[0].length; j++) {
                    if(board[i][j] == word.charAt(0) ) {
                        dfs(board, word, 0, i, j);
                        if(flag == true)
                            return flag;
                    }
                }
            }
            return flag;
        }
        private void dfs(char[][] board, String word, int index,int i,int j) {
            if(index == word.length()) {
                flag = true;
                return;
            }
            if( i>=0 && j>=0 && i<board.length && j<board[0].length && word.charAt(index) == board[i][j] )
            {
                char ch = board[i][j];
                //logic
                board[i][j] = '#';
                for(int l[] : dirs ) {
                    int r = i+l[0];
                    int c = j+l[1];
                    dfs(board, word, index+1, r, c);
                }
                board[i][j] = ch;
            }


        }
    }
}
