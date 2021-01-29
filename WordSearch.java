class Solution {
    boolean result = false;
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[0].length; j++){
                if(result==false)
                   result = helper(board, i, j, 0, word);
            }
        return result;
    }
    public boolean helper(char[][] board, int i, int j, int curr, String word){
        if(curr==(word.length())){
            // result = true;
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != word.charAt(curr))
            return false;
        board[i][j] = '-';
        if(helper(board,i+1, j, curr+1, word) || helper(board,i-1, j, curr+1, word) || helper(board,i, j+1, curr+1, word) || helper(board,i, j-1, curr+1, word))
            return true;
        
        board[i][j] = word.charAt(curr);
        
        return false;
    }
}

//Time complexity - O(N*3^l) l is the length of word
//Space complexity - O(l) N is the number of elements in the matrix
