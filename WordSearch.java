/**
 * TC : O(N) SC : O(1)
 * Approach : Using backtracking while implementing dfs for the given word. Start match for the first character and dfs in all four direction.
 *            We will eventually find the word.
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        for(int i = 0; i < board.length;  i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && helper(board,word,i,j,1))
                    return true;
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, int i, int j, int index){
        //base
        if(index == word.length()) return true;
        //logic
        int row, col;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        char temp = board[i][j];
        board[i][j] = '*';
        for(int[] dir : dirs){
            row = dir[0] + i;
            col = dir[1] + j;
            if(row < board.length && row >= 0 && col < board[0].length && col >= 0 ){
                if(board[row][col] == word.charAt(index) && helper(board,word,row,col,index+1)){
                    // System.out.println(board[row][col] + " index : " + index);
                    return true;
                }
            }
        }
        board[i][j] = temp;
        return false;
    } 
}