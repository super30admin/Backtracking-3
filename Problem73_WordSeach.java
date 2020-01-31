//Time Complexity: mn(4^l) -> where l is the lenth of the word
//Space Complexity: O(mn)

class Solution {
    private int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};

    public boolean exist(char[][] board, String word) {
        //base case
        if(board==null || board.length==0 || board[0].length==0 || word.length()==0)
            return false;
        
        //for all rows and columns 
        int row = board.length;
        int col = board[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                //if first character of the word matches
                //in the board
                if(board[i][j] == word.charAt(0)){
                    //visited
                    board[i][j]='-';
                    //backtrack
                    if(backtrack(board, i, j, word, 1))
                        return true;
                    
                    board[i][j]=word.charAt(0);
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, int i, int j, String word, int currIndex){
    
        //base case
        if(currIndex == word.length())
            return true;
        
        //check for all directions for the next character of the word in the board
        for (int[] dir : directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            //checking bounds of x and y
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '-') {
                if (board[x][y] == word.charAt(currIndex)) {
                    board[x][y] = '-';
                    if (backtrack(board, x, y, word, currIndex + 1))
                        return true;
                    board[x][y] = word.charAt(currIndex);
                }
            }
        }
        return false;
    }
}