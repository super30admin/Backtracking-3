/*
    time complexity :  
        O(M*N * 4^L ) L length of word M*n = size of board
    space compleixty:
        recursive space : O(M*N)
    
    is worked on leetcode : YES

*/

public class WordSearch {
    class Solution {
        int m;
        int n;
        int dirs[][] ;
        public boolean exist(char[][] board, String word) {
            dirs = new int [][]{{0,1},{0,-1},{1,0},{-1,0}};
            m =  board.length;
            n = board[0].length;
            
            if( board ==  null ||  m == 0 ) return false;
            char first = word.charAt(0);
            for(int i = 0;i < m;i++){
                for(int j=0; j< n;j++){
                    if( board[i][j] != first) continue;
                    if(dfs(board, word, i, j, 0)) return true;
                }
            }
            
            return false;
            
        }
        
        private boolean dfs(char[] [] board, String word, int r, int c, int index){
            // base 
            if(  r < 0 || r > m-1 || c < 0 || c > n-1 || board[r][c] =='#' ||  board[r][c] != word.charAt(index) ) return false;
            
            if( index ==  word.length()-1) return true;
            // visit the word
            char temp = board[r][c];
            board[r][c] = '#';
            for( int[] dir: dirs){
                int row = dir[0] +r;
                int col =  dir[1] + c;
                if( dfs(board, word, row, col, index +1 )) return true;
            }
            
            // backtrack
            board[r][c] =  temp;
            return false;
        }
        
    }
}