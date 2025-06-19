// Time complexity: O(n^n)
//Space complexity: O(1)
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(solve(board,i,j,word,0)) return true;
            }
        }
        return false;
    }
    public boolean solve(char[][] board, int i, int j, String word, int k){
        // System.out.println(i+", "+j);
        if(k>=word.length()) return true;
        if(i<0 || i>=board.length) return false;
        if(j<0 || j>=board[0].length) return false;
        if(board[i][j]==word.charAt(k)){
            // System.out.println("equall");
            char temp = board[i][j];
            board[i][j] = ' ';
            boolean res = solve(board,i+1,j,word,k+1) || solve(board,i-1,j,word,k+1) || 
                    solve(board,i,j+1,word,k+1) || solve(board,i,j-1,word,k+1) ;
            board[i][j] = temp;
            return res;
        }
        return false;
    }
}