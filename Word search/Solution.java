// Time complexity: O(n^2)
// Space Complexity: O(n)
class Solution {
    int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                     boolean b = helper(board, 0,word,i,j);
                if(b==true) return true;
                }
               
            }
        }

        return false;
    }
    
    private boolean helper(char[][] board, int i, String word, int m, int n){
        if(i==word.length()) return true;
         if(m < 0 || n < 0 || m == board.length || n == board[0].length || board[m][n]=='#'){
             return false;
         }
        char c = word.charAt(i);
        if(c==board[m][n]){
             for(int [] dir : dirs){
            int a = m + dir[0];
            int b = n + dir[1];
            
                board[m][n]='#';
                boolean x= helper(board,i+1,word,a,b);
                if(x==true){
                    return true;
                }
                 board[m][n]=c;
        }
        }
        return false;
    }
}
